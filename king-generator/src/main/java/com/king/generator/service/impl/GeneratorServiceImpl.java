package com.king.generator.service.impl;

import com.king.common.constant.Constants;
import com.king.generator.config.GenConfig;
import com.king.generator.mapper.GenTableColumnMapper;
import com.king.generator.mapper.GenTableMapper;
import com.king.generator.pojo.GenTable;
import com.king.generator.pojo.GenTableColumn;
import com.king.generator.service.GeneratorServiceI;
import com.king.generator.util.VelocityUtils;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class GeneratorServiceImpl implements GeneratorServiceI {
    private GenTableColumnMapper genTableColumnMapper;
    private GenTableMapper genTableMapper;

    @Autowired
    public void setGenTableColumnMapper(GenTableColumnMapper genTableColumnMapper) {
        this.genTableColumnMapper = genTableColumnMapper;
    }

    @Autowired
    public void setGenTableMapper(GenTableMapper genTableMapper) {
        this.genTableMapper = genTableMapper;
    }

    @Override
    public byte[] generatorCode(String tableName) {
        /*
        处理表名
         */
        String[] strings = tableName.split("_");

        StringBuilder pojoNameBuffer = new StringBuilder();
        StringBuilder urlNameBuffer = new StringBuilder();

        for (String s : strings) {
            pojoNameBuffer.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
            urlNameBuffer.append("/").append(s);
        }

        String pojoName = pojoNameBuffer.toString();
        String urlName = urlNameBuffer.toString();
        String packageName = GenConfig.getPackageName();
        String[] packageNameSplitArray = packageName.split("\\.");

        /*
        读取表信息
         */
        GenTable genTable = genTableMapper.select4DetailByTableName(tableName);

        List<GenTableColumn> genTableColumns = genTableColumnMapper.selectTableColumnsByTableName(tableName);

        // 去掉公共字段createUserId,updateUserId,createTime,updateTime,deleteFlag,id
        List<GenTableColumn> columnsWithOutDefaultFields = new LinkedList<>();

        for (GenTableColumn column : genTableColumns) {
            if (!VelocityUtils.getDefaultFieldNames().contains(column.getColumnName())) {
                columnsWithOutDefaultFields.add(column);
            }
        }

        genTableColumns = columnsWithOutDefaultFields;

        genTable.setColumns(genTableColumns);
        genTable.setClassName(pojoName);
        genTable.setUrlName(urlName);
        genTable.setPackageName(packageName);
        genTable.setModuleName(packageNameSplitArray[packageNameSplitArray.length - 1]);
        genTable.setObjName(pojoName.substring(0, 1).toLowerCase() + pojoName.substring(1));

        for (GenTableColumn genTableColumn : genTableColumns) {
            if (genTableColumn.getColumnType().startsWith("varchar")) {
                genTableColumn.setJavaType("String");
                genTableColumn.setJdbcType("VARCHAR");
            } else if (genTableColumn.getColumnType().startsWith("datetime")) {
                genTableColumn.setJavaType("String");
                genTableColumn.setJdbcType("TIMESTAMP");
            } else if (genTableColumn.getColumnType().startsWith("tinyint")) {
                genTableColumn.setJavaType("Integer");
                genTableColumn.setJdbcType("TINYINT");
            } else if (genTableColumn.getColumnType().startsWith("int")) {
                genTableColumn.setJavaType("Integer");
                genTableColumn.setJdbcType("INTEGER");
            } else {
                genTableColumn.setJavaType("String");
            }
        }

        /*
        将表信息填到模板里，生成文件，添加到zip中
         */
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        VelocityContext ctx = new VelocityContext();

        ctx.put("table", genTable);

        Map<String, String> map = VelocityUtils.mapTemplate2FileName(pojoName);

        Set<Map.Entry<String, String>> entries = map.entrySet();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (Map.Entry<String, String> entry : entries) {
            Template tpl = ve.getTemplate(entry.getKey(), Constants.UTF8);

            StringWriter sw = new StringWriter();
            tpl.merge(ctx, sw);

            try {
                zip.putNextEntry(new ZipEntry(entry.getValue()));
                IOUtils.write(sw.toString(), zip, Constants.UTF8);
                sw.close();
                zip.flush();
                zip.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            zip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream.toByteArray();
    }

    @Override
    public List<GenTable> read4GenTable(GenTable genTable) {
        return genTableMapper.select4GenTable(genTable);
    }

    @Override
    public int select4TableCount(GenTable genTable) {
        return genTableMapper.select4Count(genTable);
    }
}

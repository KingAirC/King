package com.king.generator.service.impl;

import com.king.common.constant.Constants;
import com.king.common.util.StringUtils;
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
        读取表信息
         */
        GenTable genTable = genTableMapper.select4DetailByTableName(tableName);
        genTable.setPkColumns(new LinkedList<>());

        List<GenTableColumn> genTableColumns = genTableColumnMapper.selectTableColumnsByTableName(tableName);
        genTable.setColumns(genTableColumns);

        String pojoName = StringUtils.convertTableName2PojoName(tableName);
        genTable.setClassName(pojoName);

        genTable.setPackageName(GenConfig.getPackageName());

        for (GenTableColumn genTableColumn : genTableColumns) {
            if (genTableColumn.getColumnType().startsWith("varchar") || genTableColumn.getColumnType().startsWith("datetime")) {
                genTableColumn.setJavaType("String");
            } else if (genTableColumn.getColumnType().startsWith("tinyint") || genTableColumn.getColumnType().startsWith("int")) {
                genTableColumn.setJavaType("Integer");
            } else {
                genTableColumn.setJavaType("String");
            }
            if ("PRI".equals(genTableColumn.getKey())) {
                genTableColumn.setIsPk(true);
                genTable.getPkColumns().add(genTableColumn);
            } else {
                genTableColumn.setIsPk(false);
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
            Template tpl = ve.getTemplate(entry.getKey());

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

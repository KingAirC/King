package com.king.generator.service.impl;

import com.king.common.util.StringUtils;
import com.king.generator.mapper.MysqlFieldMapper;
import com.king.generator.mapper.MysqlTableMapper;
import com.king.generator.pojo.MysqlField;
import com.king.generator.pojo.MysqlTable;
import com.king.generator.service.GeneratorServiceI;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class GeneratorServiceImpl implements GeneratorServiceI {
    private MysqlFieldMapper mysqlFieldMapper;
    private MysqlTableMapper mysqlTableMapper;

    @Autowired
    public void setMysqlFieldMapper(MysqlFieldMapper mysqlFieldMapper) {
        this.mysqlFieldMapper = mysqlFieldMapper;
    }

    @Autowired
    public void setMysqlTableMapper(MysqlTableMapper mysqlTableMapper) {
        this.mysqlTableMapper = mysqlTableMapper;
    }

    @Override
    public void generate(String tableName) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        Template pojoTpl = ve.getTemplate("vm/java/Pojo.java.vm");
        VelocityContext ctx = new VelocityContext();

        List<MysqlField> mysqlFieldList = mysqlFieldMapper.selectMysqlFieldsByTableName(tableName);

        for (MysqlField mysqlField : mysqlFieldList) {
            if (mysqlField.getType().startsWith("varchar") ||
                    mysqlField.getType().startsWith("datetime")) {
                mysqlField.setTypeStr("String");
            } else if (mysqlField.getType().startsWith("tinyint") ||
                    mysqlField.getType().startsWith("int")) {
                mysqlField.setTypeStr("Integer");
            } else {
                mysqlField.setTypeStr("String");
            }
            mysqlField.setPk("PRI".equals(mysqlField.getKey()));
        }

        String pojoName = StringUtils.convertTableName2PojoName(tableName);

        ctx.put("pojoName", pojoName);
        ctx.put("pojoAttrs", mysqlFieldList);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pojoName + ".java");
            pojoTpl.merge(ctx, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<MysqlTable> read4MysqlTable(MysqlTable mysqlTable) {
        return mysqlTableMapper.select4MysqlTable(mysqlTable);
    }

    @Override
    public int select4TableCount(MysqlTable mysqlTable) {
        return mysqlTableMapper.select4Count(mysqlTable);
    }
}

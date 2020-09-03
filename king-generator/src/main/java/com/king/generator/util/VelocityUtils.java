package com.king.generator.util;

import java.util.HashMap;
import java.util.Map;

public class VelocityUtils {

    public static Map<String, String> mapTemplate2FileName(String pojoName) {
        Map<String, String> result = new HashMap<>();

        result.put("vm/single/html/add.html.vm", "add.html");
        result.put("vm/single/html/detail.html.vm", "detail.html");
        result.put("vm/single/html/edit.html.vm", "edit.html");
        result.put("vm/single/html/list.html.vm", "list.html");

        result.put("vm/single/java/Controller.java.vm", pojoName + "Controller.java");
        result.put("vm/single/java/Mapper.java.vm", pojoName + "Mapper.java");
        result.put("vm/single/java/Pojo.java.vm", pojoName + ".java");
        result.put("vm/single/java/ServiceI.java.vm", pojoName + "ServiceI.java");
        result.put("vm/single/java/ServiceImpl.java.vm", pojoName + "ServiceImpl.java");
        result.put("vm/single/java/Tests.java.vm", pojoName + "Tests.java");

        result.put("vm/single/sql/sql.sql.vm", "sql.sql");

        result.put("vm/single/xml/Mapper.xml.vm", pojoName + "Mapper.xml");

        return result;
    }

}

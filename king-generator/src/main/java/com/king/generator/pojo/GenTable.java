package com.king.generator.pojo;

import lombok.Data;

import java.util.List;

@Data
public class GenTable {
    private String tableName;
    private String tableComment;
    private String className;
    private String objName;
    private String packageName;
    private String urlName;
    private String moduleName;
    private List<GenTableColumn> columns;
}

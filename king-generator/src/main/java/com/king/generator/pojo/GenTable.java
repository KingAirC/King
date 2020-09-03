package com.king.generator.pojo;

import lombok.Data;

import java.util.List;

@Data
public class GenTable {
    private String tableName;
    private String tableComment;
    private String className;
    private String packageName;
    private List<GenTableColumn> pkColumns;
    private List<GenTableColumn> columns;
}

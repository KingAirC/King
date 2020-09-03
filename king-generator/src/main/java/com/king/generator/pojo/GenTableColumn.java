package com.king.generator.pojo;

import lombok.Data;

@Data
public class GenTableColumn {
    private String tableName;
    private String columnName;
    private String columnComment;
    private String columnType;
    private String javaType;
    private String key;
    private Boolean isPk;
}

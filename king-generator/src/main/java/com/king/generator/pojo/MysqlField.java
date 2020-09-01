package com.king.generator.pojo;

import lombok.Data;

@Data
public class MysqlField {
    private String field;
    private String type;
    private String typeStr;
    private String comment;
    private String key;
    private boolean pk;
}

package com.king.system.pojo;

import lombok.Data;

@Data
public class SysRole {
    private String id;
    private String name;
    private String createUserId;
    private String updateUserId;
    private String createTime;
    private String updateTime;
    private Integer deleteFlag;
}

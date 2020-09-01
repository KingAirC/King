package com.king.system.pojo;

import lombok.Data;

@Data
public class SysMenu {
    private String id;
    private String name;
    private String pid;
    private String href;
    private String remark;
    private String icon;
    private Integer sort;
    private String target;
    private String type;
    private String permission;
    private String createUserId;
    private String updateUserId;
    private String createTime;
    private String updateTime;
    private Integer deleteFlag;
}

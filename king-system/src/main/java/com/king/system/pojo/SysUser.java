package com.king.system.pojo;

import lombok.Data;

@Data
public class SysUser {
    private String id;
    private String loginName;
    private String realName;
    private String passwordText;
    private String passwordEncrypt;
    private String salt;
    private String tel;
    private String birthday;
    private Integer gender;
    private String signature;
    private String qq;
    private String createUserId;
    private String updateUserId;
    private String createTime;
    private String updateTime;
    private Integer deleteFlag;
    private Integer ageMin;
    private Integer ageMax;
}

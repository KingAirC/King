package com.king.system.service;

import com.king.system.pojo.SysRole;
import com.king.system.pojo.SysUser;

import java.util.List;

public interface SysRoleServiceI {

    /**
     * 添加，属性为null就是默认值
     *
     * @param sysRole pojo
     * @return 是否插入成功
     */
    boolean create(SysRole sysRole);

    /**
     * 批量添加
     *
     * @param sysRoles pojo列表
     * @return 是否插入成功
     */
    boolean createBatch(List<SysRole> sysRoles);

    /**
     * 根据主键删除记录
     *
     * @param sysRole pojo
     * @return 是否删除成功
     */
    boolean deleteByPk(SysRole sysRole);

    /**
     * 批量删除
     *
     * @param sysRoles pojo列表
     * @return 是否删除成功
     */
    boolean deleteBatch(List<SysRole> sysRoles);

    /**
     * 根据主键更新
     *
     * @param sysRole pojo
     * @return 是否更新成功
     */
    boolean updateByPk(SysRole sysRole);

    /**
     * 更新删除标识符
     *
     * @param sysRole pojo
     * @return 是否成功
     */
    boolean updateDeleteFlag(SysRole sysRole);

    /**
     * 根据主键查询详细
     *
     * @param sysRole pojo
     * @return pojo
     */
    SysRole read4DetailByPk(SysRole sysRole);

    /**
     * 根据pojo非空字段查询列表
     *
     * @param sysRole pojo
     * @return pojo列表
     */
    List<SysRole> read4List(SysRole sysRole);

    /**
     * 根据pojo非空字段查询数量
     *
     * @param sysRole pojo
     * @return 数量
     */
    int read4Count(SysRole sysRole);


    /**
     * 根据SysUser的name查询它具有所有的角色
     *
     * @param sysUser pojo
     * @return List
     */
    List<SysRole> read4SysRoleListBySysUserName(SysUser sysUser);

    List<String> read4SysRoleNameListBySysUserName(SysUser sysUser);

}

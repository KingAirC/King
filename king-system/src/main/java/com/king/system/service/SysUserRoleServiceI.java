package com.king.system.service;

import com.king.system.pojo.SysUserRole;

import java.util.List;

public interface SysUserRoleServiceI {

    /**
     * 添加，属性为null就是默认值
     *
     * @param sysUserRole pojo
     * @return 是否插入成功
     */
    boolean create(SysUserRole sysUserRole);

    /**
     * 批量添加
     *
     * @param sysUserRoles pojo列表
     * @return 是否插入成功
     */
    boolean createBatch(List<SysUserRole> sysUserRoles);

    /**
     * 根据主键删除记录
     *
     * @param sysUserRole pojo
     * @return 是否删除成功
     */
    boolean deleteByPk(SysUserRole sysUserRole);

    /**
     * 根据userId批量删除
     *
     * @param sysUserRole pojo
     * @return 是否成功
     */
    boolean deleteBatchByUserId(SysUserRole sysUserRole);

    /**
     * 根据roleId批量删除
     *
     * @param sysUserRole pojo
     * @return 是否成功
     */
    boolean deleteBatchByRoleId(SysUserRole sysUserRole);

}

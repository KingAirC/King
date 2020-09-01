package com.king.system.service;

import com.king.system.pojo.SysRoleMenu;

import java.util.List;

public interface SysRoleMenuServiceI {

    /**
     * 添加
     *
     * @param sysRoleMenu pojo
     * @return 是否成功
     */
    boolean create(SysRoleMenu sysRoleMenu);

    /**
     * 批量添加
     *
     * @param sysRoleMenus List
     * @return 是否成功
     */
    boolean createBatch(List<SysRoleMenu> sysRoleMenus);

    /**
     * 根据主键删除
     *
     * @param sysRoleMenu pojo
     * @return 是否成功
     */
    boolean deleteByPk(SysRoleMenu sysRoleMenu);

    /**
     * 根据RoleId批量删除
     *
     * @param sysRoleMenu pojo
     * @return 是否成功
     */
    boolean deleteBatchByRoleId(SysRoleMenu sysRoleMenu);

    /**
     * 根据MenuId批量删除
     *
     * @param sysRoleMenu pojo
     * @return 是否成功
     */
    boolean deleteBatchByMenuId(SysRoleMenu sysRoleMenu);
}

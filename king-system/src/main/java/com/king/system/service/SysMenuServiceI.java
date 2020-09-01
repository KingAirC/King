package com.king.system.service;

import com.king.system.pojo.SysMenu;
import com.king.system.pojo.SysUser;

import java.util.List;

public interface SysMenuServiceI {

    /**
     * 添加，属性为null就是默认值
     *
     * @param sysMenu pojo
     * @return 是否插入成功
     */
    boolean create(SysMenu sysMenu);

    /**
     * 批量添加
     *
     * @param sysMenus pojo列表
     * @return 是否插入成功
     */
    boolean createBatch(List<SysMenu> sysMenus);

    /**
     * 根据主键删除记录
     *
     * @param sysMenu pojo
     * @return 是否删除成功
     */
    boolean deleteByPk(SysMenu sysMenu);

    /**
     * 批量删除
     *
     * @param sysMenus pojo列表
     * @return 是否删除成功
     */
    boolean deleteBatch(List<SysMenu> sysMenus);

    /**
     * 根据主键更新
     *
     * @param sysMenu pojo
     * @return 是否更新成功
     */
    boolean updateByPk(SysMenu sysMenu);

    /**
     * 更新删除标识符
     *
     * @param sysMenu pojo
     * @return 是否成功
     */
    boolean updateDeleteFlag(SysMenu sysMenu);

    /**
     * 根据主键查询详细
     *
     * @param sysMenu pojo
     * @return pojo
     */
    SysMenu read4DetailByPk(SysMenu sysMenu);

    /**
     * 根据pojo非空字段查询列表
     *
     * @param sysMenu pojo
     * @return pojo列表
     */
    List<SysMenu> read4List(SysMenu sysMenu);

    /**
     * 查询全部
     *
     * @return List
     */
    List<SysMenu> read4List();

    /**
     * 根据pojo非空字段查询数量
     *
     * @param sysMenu pojo
     * @return 数量
     */
    int read4Count(SysMenu sysMenu);

    List<String> read4PermissionListBySysUserLoginName(SysUser sysUser);

    /**
     * 读取目录和菜单列表
     *
     * @return List
     */
    List<SysMenu> read4DirAndMenuList();
}

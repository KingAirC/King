package com.king.system.service;

import com.king.system.pojo.SysUser;

import java.util.List;

public interface SysUserServiceI {

    /**
     * 添加，属性为null就是默认值
     *
     * @param sysUser pojo
     * @return 是否插入成功
     */
    boolean create(SysUser sysUser);

    /**
     * 批量添加
     *
     * @param sysUsers pojo列表
     * @return 是否插入成功
     */
    boolean createBatch(List<SysUser> sysUsers);

    /**
     * 根据主键删除记录
     *
     * @param sysUser pojo
     * @return 是否删除成功
     */
    boolean deleteByPk(SysUser sysUser);

    /**
     * 批量删除
     *
     * @param sysUsers pojo列表
     * @return 是否删除成功
     */
    boolean deleteBatch(List<SysUser> sysUsers);

    /**
     * 根据主键更新
     *
     * @param sysUser pojo
     * @return 是否更新成功
     */
    boolean updateByPk(SysUser sysUser);

    /**
     * 更新删除标识符
     *
     * @param sysUser pojo
     * @return 是否成功
     */
    boolean updateDeleteFlag(SysUser sysUser);

    /**
     * 根据主键查询详细
     *
     * @param sysUser pojo
     * @return pojo
     */
    SysUser read4DetailByPk(SysUser sysUser);

    /**
     * 根据pojo非空字段查询列表
     *
     * @param sysUser pojo
     * @return pojo列表
     */
    List<SysUser> read4List(SysUser sysUser);

    /**
     * 根据pojo非空字段查询数量
     *
     * @param sysUser pojo
     * @return 数量
     */
    int read4Count(SysUser sysUser);

    int read4NameCount(String username);

    SysUser read4DetailByName(String username);
}

package com.king.system.mapper;

import com.king.system.pojo.SysRoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMenuMapper {

    /**
     * 添加
     *
     * @param sysRoleMenu pojo
     * @return 条数
     */
    int insert(SysRoleMenu sysRoleMenu);

    /**
     * 选择性添加
     *
     * @param sysRoleMenu pojo
     * @return 条数
     */
    int insertSelective(SysRoleMenu sysRoleMenu);

    /**
     * 批量添加
     *
     * @param sysRoleMenus List
     * @return 条数
     */
    int insertBatch(List<SysRoleMenu> sysRoleMenus);

    /**
     * 批量选择性添加
     *
     * @param sysRoleMenus List
     * @return 条数
     */
    int insertBatchSelective(List<SysRoleMenu> sysRoleMenus);

    /**
     * 根据主键删除
     *
     * @param sysRoleMenu pojo
     * @return 条数
     */
    int deleteByPk(SysRoleMenu sysRoleMenu);

    /**
     * 根据RoleId批量删除
     *
     * @param sysRoleMenu pojo
     * @return 条数
     */
    int deleteBatchByRoleId(SysRoleMenu sysRoleMenu);

    /**
     * 根据MenuId批量删除
     *
     * @param sysRoleMenu pojo
     * @return 条数
     */
    int deleteBatchByMenuId(SysRoleMenu sysRoleMenu);
}

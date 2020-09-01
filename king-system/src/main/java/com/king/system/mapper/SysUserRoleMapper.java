package com.king.system.mapper;

import com.king.system.pojo.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleMapper {

    /**
     * 添加
     *
     * @param sysUserRole pojo
     * @return 条数
     */
    int insert(SysUserRole sysUserRole);

    /**
     * 选择性添加
     *
     * @param sysUserRole pojo
     * @return 添加条数
     */
    int insertSelective(SysUserRole sysUserRole);

    /**
     * 批量选择性添加
     *
     * @param sysUserRoles List
     * @return 添加条数
     */
    int insertBatchSelective(List<SysUserRole> sysUserRoles);

    /**
     * 批量添加
     *
     * @param sysUserRoles List
     * @return 条数
     */
    int insertBatch(List<SysUserRole> sysUserRoles);

    /**
     * 根据主键删除
     *
     * @param sysUserRole pojo
     * @return 条数
     */
    int deleteByPk(SysUserRole sysUserRole);

    /**
     * 根据userId批量删除
     *
     * @param sysUserRole pojo
     * @return 条数
     */
    int deleteBatchByUserId(SysUserRole sysUserRole);

    /**
     * 根据roleId批量删除
     *
     * @param sysUserRole pojo
     * @return 条数
     */
    int deleteBatchByRoleId(SysUserRole sysUserRole);

}

package com.king.system.mapper;

import com.king.system.pojo.SysRole;
import com.king.system.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {

    /**
     * 添加，属性为null就是默认值
     *
     * @param sysRole pojo
     * @return 插入的条数
     */
    int insert(SysRole sysRole);

    /**
     * 批量添加
     *
     * @param sysRoles pojo列表
     * @return 插入的条数
     */
    int insertBatch(List<SysRole> sysRoles);

    /**
     * 批量选择性添加
     *
     * @param sysRoles List
     * @return 插入条数
     */
    int insertBatchSelective(List<SysRole> sysRoles);

    /**
     * 选择性添加
     *
     * @param sysRole pojo
     * @return 添加条数
     */
    int insertSelective(SysRole sysRole);

    /**
     * 根据主键删除记录
     *
     * @param sysRole pojo
     * @return 删除的条数
     */
    int deleteByPk(SysRole sysRole);

    /**
     * 批量删除
     *
     * @param sysRoles pojo列表
     * @return 删除的条数
     */
    int deleteBatch(List<SysRole> sysRoles);

    /**
     * 根据主键更新
     *
     * @param sysRole pojo
     * @return 更新的条数
     */
    int updateByPk(SysRole sysRole);

    /**
     * 根据主键选择性更新字段
     *
     * @param sysRole pojo
     * @return 更新的条数
     */
    int updateByPkSelective(SysRole sysRole);

    /**
     * 更新删除标识符
     *
     * @param sysRole pojo
     * @return 更新条数
     */
    int updateDeleteFlag(SysRole sysRole);

    /**
     * 根据主键查询详细
     *
     * @param sysRole pojo
     * @return pojo
     */
    SysRole select4DetailByPk(SysRole sysRole);

    /**
     * 根据pojo非空字段查询列表
     *
     * @param sysRole pojo
     * @return pojo列表
     */
    List<SysRole> select4List(SysRole sysRole);

    /**
     * 选择性查询列表
     *
     * @param sysRole pojo
     * @return List
     */
    List<SysRole> select4ListSelective(SysRole sysRole);

    /**
     * 根据pojo非空字段查询数量
     *
     * @param sysRole pojo
     * @return 数量
     */
    int select4Count(SysRole sysRole);

    List<SysRole> selectBySysUserName(SysUser sysUser);

    List<String> select4NameBySysUserName(SysUser sysUser);
}

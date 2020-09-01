package com.king.system.mapper;

import com.king.system.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {

    /**
     * 添加，属性为null就是默认值
     *
     * @param sysUser pojo
     * @return 插入的条数
     */
    int insert(SysUser sysUser);

    /**
     * 批量添加
     *
     * @param sysUsers pojo列表
     * @return 插入的条数
     */
    int insertBatch(List<SysUser> sysUsers);

    /**
     * 批量选择性添加
     * @param sysUsers pojo
     * @return 添加条数
     */
    int insertBatchSelective(List<SysUser> sysUsers);

    /**
     * 选择性添加
     *
     * @param sysUser pojo
     * @return 添加条数
     */
    int insertSelective(SysUser sysUser);

    /**
     * 根据主键删除记录
     *
     * @param sysUser pojo
     * @return 删除的条数
     */
    int deleteByPk(SysUser sysUser);

    /**
     * 批量删除
     *
     * @param sysUsers pojo列表
     * @return 删除的条数
     */
    int deleteBatch(List<SysUser> sysUsers);

    /**
     * 根据主键更新
     *
     * @param sysUser pojo
     * @return 更新的条数
     */
    int updateByPk(SysUser sysUser);

    /**
     * 根据主键选择性更新字段
     *
     * @param sysUser pojo
     * @return 更新的条数
     */
    int updateByPkSelective(SysUser sysUser);

    /**
     * 更新删除标识符
     *
     * @param sysUser pojo
     * @return 更新条数
     */
    int updateDeleteFlag(SysUser sysUser);

    /**
     * 根据主键查询详细
     *
     * @param sysUser pojo
     * @return pojo
     */
    SysUser select4DetailByPk(SysUser sysUser);

    /**
     * 根据pojo非空字段查询列表
     *
     * @param sysUser pojo
     * @return pojo列表
     */
    List<SysUser> select4List(SysUser sysUser);

    /**
     * 选择性查询列表
     *
     * @param sysUser pojo
     * @return List
     */
    List<SysUser> select4ListSelective(SysUser sysUser);

    /**
     * 根据pojo非空字段查询数量
     *
     * @param sysUser pojo
     * @return 数量
     */
    int select4Count(SysUser sysUser);

    int select4NameCount(String username);

    SysUser selectDetailByName(String username);
}

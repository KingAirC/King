package com.king.system.mapper;

import com.king.system.pojo.SysMenu;
import com.king.system.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuMapper {

    /**
     * 添加，属性为null就是默认值
     *
     * @param sysMenu pojo
     * @return 插入的条数
     */
    int insert(SysMenu sysMenu);

    /**
     * 批量添加
     *
     * @param sysMenus pojo列表
     * @return 插入的条数
     */
    int insertBatch(List<SysMenu> sysMenus);

    /**
     * 批量选择性添加
     *
     * @param sysMenus pojo
     * @return 是否添加成功
     */
    int insertBatchSelective(List<SysMenu> sysMenus);

    /**
     * 选择性添加
     *
     * @param sysMenu pojo
     * @return 添加条数
     */
    int insertSelective(SysMenu sysMenu);

    /**
     * 根据主键删除记录
     *
     * @param sysMenu pojo
     * @return 删除的条数
     */
    int deleteByPk(SysMenu sysMenu);

    /**
     * 批量删除
     *
     * @param sysMenus pojo列表
     * @return 删除的条数
     */
    int deleteBatch(List<SysMenu> sysMenus);

    /**
     * 根据主键更新
     *
     * @param sysMenu pojo
     * @return 更新的条数
     */
    int updateByPk(SysMenu sysMenu);

    /**
     * 根据主键选择性更新字段
     *
     * @param sysMenu pojo
     * @return 更新的条数
     */
    int updateByPkSelective(SysMenu sysMenu);

    /**
     * 更新删除标识符
     *
     * @param sysMenu pojo
     * @return 更新条数
     */
    int updateDeleteFlag(SysMenu sysMenu);

    /**
     * 根据主键查询详细
     *
     * @param sysMenu pojo
     * @return pojo
     */
    SysMenu select4DetailByPk(SysMenu sysMenu);

    /**
     * 根据pojo非空字段查询列表
     *
     * @return pojo列表
     */
    List<SysMenu> select4List();

    /**
     * 根据pojo非空字段选择性查询列表
     *
     * @param sysMenu pojo
     * @return pojo列表
     */
    List<SysMenu> select4ListSelective(SysMenu sysMenu);

    /**
     * 根据pojo非空字段查询数量
     *
     * @param sysMenu pojo
     * @return 数量
     */
    int select4Count(SysMenu sysMenu);

    List<String> select4PermissionListByShiroUserLoginName(SysUser sysUser);

    List<SysMenu> select4DirAndMenuList();

    List<String> select4PermissionListAll();

}

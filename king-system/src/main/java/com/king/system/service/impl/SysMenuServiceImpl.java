package com.king.system.service.impl;

import com.king.common.util.PrimaryKeyUtils;
import com.king.system.mapper.SysMenuMapper;
import com.king.system.pojo.SysMenu;
import com.king.system.pojo.SysUser;
import com.king.system.service.SysMenuServiceI;
import com.king.system.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuServiceI {

    private SysMenuMapper sysMenuMapper;

    @Autowired
    public void setSysMenuMapper(SysMenuMapper sysMenuMapper) {
        this.sysMenuMapper = sysMenuMapper;
    }

    @Override
    public boolean create(SysMenu sysMenu) {
        sysMenu.setId(PrimaryKeyUtils.uuid());
        sysMenu.setCreateUserId(ShiroUtils.getLoginUserId());
        sysMenu.setUpdateUserId(sysMenu.getCreateUserId());

        return sysMenuMapper.insertSelective(sysMenu) > 0;
    }

    @Override
    public boolean createBatch(List<SysMenu> sysMenus) {
        for (SysMenu sysMenu : sysMenus) {
            sysMenu.setId(PrimaryKeyUtils.uuid());
            sysMenu.setCreateUserId(ShiroUtils.getLoginUserId());
            sysMenu.setUpdateUserId(sysMenu.getCreateUserId());
        }

        return sysMenuMapper.insertBatchSelective(sysMenus) > 0;
    }

    @Override
    public boolean deleteByPk(SysMenu sysMenu) {
        return sysMenuMapper.deleteByPk(sysMenu) > 0;
    }

    @Override
    public boolean deleteBatch(List<SysMenu> sysMenus) {
        return sysMenuMapper.deleteBatch(sysMenus) > 0;
    }

    @Override
    public boolean updateByPk(SysMenu sysMenu) {
        sysMenu.setUpdateUserId(ShiroUtils.getLoginUserId());

        return sysMenuMapper.updateByPkSelective(sysMenu) > 0;
    }

    @Override
    public boolean updateDeleteFlag(SysMenu sysMenu) {
        sysMenu.setUpdateUserId(ShiroUtils.getLoginUserId());

        return sysMenuMapper.updateDeleteFlag(sysMenu) > 0;
    }

    @Override
    public SysMenu read4DetailByPk(SysMenu sysMenu) {
        return sysMenuMapper.select4DetailByPk(sysMenu);
    }

    @Override
    public List<SysMenu> read4List(SysMenu sysMenu) {
        return sysMenuMapper.select4ListSelective(sysMenu);
    }

    @Override
    public List<SysMenu> read4List() {
        return sysMenuMapper.select4List();
    }

    @Override
    public int read4Count(SysMenu sysMenu) {
        return sysMenuMapper.select4Count(sysMenu);
    }

    @Override
    public List<String> read4PermissionListBySysUserLoginName(SysUser sysUser) {
        return sysMenuMapper.select4PermissionListByShiroUserLoginName(sysUser);
    }

    @Override
    public List<SysMenu> read4DirAndMenuList() {
        return sysMenuMapper.select4DirAndMenuList();
    }
}

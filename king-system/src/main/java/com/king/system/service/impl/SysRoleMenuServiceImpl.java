package com.king.system.service.impl;

import com.king.system.mapper.SysRoleMenuMapper;
import com.king.system.pojo.SysRoleMenu;
import com.king.system.service.SysRoleMenuServiceI;
import com.king.system.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuServiceI {

    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    public void setSysRoleMenuMapper(SysRoleMenuMapper sysRoleMenuMapper) {
        this.sysRoleMenuMapper = sysRoleMenuMapper;
    }

    @Override
    public boolean create(SysRoleMenu sysRoleMenu) {
        sysRoleMenu.setCreateUserId(ShiroUtils.getLoginUserId());

        return sysRoleMenuMapper.insertSelective(sysRoleMenu) > 0;
    }

    @Override
    public boolean createBatch(List<SysRoleMenu> sysRoleMenus) {
        for (SysRoleMenu sysRoleMenu : sysRoleMenus) {
            sysRoleMenu.setCreateUserId(ShiroUtils.getLoginUserId());
        }

        return sysRoleMenuMapper.insertBatchSelective(sysRoleMenus) > 0;
    }

    @Override
    public boolean deleteByPk(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.deleteByPk(sysRoleMenu) > 0;
    }

    @Override
    public boolean deleteBatchByRoleId(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.deleteBatchByRoleId(sysRoleMenu) > 0;
    }

    @Override
    public boolean deleteBatchByMenuId(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.deleteBatchByMenuId(sysRoleMenu) > 0;
    }
}

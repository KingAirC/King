package com.king.system.service.impl;

import com.king.common.util.PrimaryKeyUtils;
import com.king.system.mapper.SysRoleMapper;
import com.king.system.pojo.SysRole;
import com.king.system.pojo.SysUser;
import com.king.system.service.SysRoleServiceI;
import com.king.system.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleServiceI {

    private SysRoleMapper sysRoleMapper;
    
    @Autowired
    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public boolean create(SysRole sysRole) {
        sysRole.setId(PrimaryKeyUtils.uuid());
        sysRole.setCreateUserId(ShiroUtils.getLoginUserId());
        sysRole.setUpdateUserId(sysRole.getCreateUserId());

        return sysRoleMapper.insertSelective(sysRole) > 0;
    }

    @Override
    public boolean createBatch(List<SysRole> sysRoles) {
        for (SysRole sysRole : sysRoles) {
            sysRole.setId(PrimaryKeyUtils.uuid());
            sysRole.setCreateUserId(ShiroUtils.getLoginUserId());
            sysRole.setUpdateUserId(sysRole.getCreateUserId());
        }

        return sysRoleMapper.insertBatchSelective(sysRoles) > 0;
    }

    @Override
    public boolean deleteByPk(SysRole sysRole) {
        return sysRoleMapper.deleteByPk(sysRole) > 0;
    }

    @Override
    public boolean deleteBatch(List<SysRole> sysRoles) {
        return sysRoleMapper.deleteBatch(sysRoles) > 0;
    }

    @Override
    public boolean updateByPk(SysRole sysRole) {
        sysRole.setUpdateUserId(ShiroUtils.getLoginUserId());

        return sysRoleMapper.updateByPkSelective(sysRole) > 0;
    }

    @Override
    public boolean updateDeleteFlag(SysRole sysRole) {
        sysRole.setUpdateUserId(ShiroUtils.getLoginUserId());

        return sysRoleMapper.updateDeleteFlag(sysRole) > 0;
    }

    @Override
    public SysRole read4DetailByPk(SysRole sysRole) {
        return sysRoleMapper.select4DetailByPk(sysRole);
    }

    @Override
    public List<SysRole> read4List(SysRole sysRole) {
        return sysRoleMapper.select4ListSelective(sysRole);
    }

    @Override
    public int read4Count(SysRole sysRole) {
        return sysRoleMapper.select4Count(sysRole);
    }

    @Override
    public List<SysRole> read4SysRoleListBySysUserName(SysUser sysUser) {
        return sysRoleMapper.selectBySysUserName(sysUser);
    }

    @Override
    public List<String> read4SysRoleNameListBySysUserName(SysUser sysUser) {
        return sysRoleMapper.select4NameBySysUserName(sysUser);
    }
}

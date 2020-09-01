package com.king.system.service.impl;

import com.king.system.mapper.SysUserRoleMapper;
import com.king.system.pojo.SysUserRole;
import com.king.system.service.SysUserRoleServiceI;
import com.king.system.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleServiceI {

    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    public void setSysUserRoleMapper(SysUserRoleMapper sysUserRoleMapper) {
        this.sysUserRoleMapper = sysUserRoleMapper;
    }

    @Override
    public boolean create(SysUserRole sysUserRole) {
        sysUserRole.setCreateUserId(ShiroUtils.getLoginUserId());

        return sysUserRoleMapper.insertSelective(sysUserRole) > 0;
    }

    @Override
    public boolean createBatch(List<SysUserRole> sysUserRoles) {
        for (SysUserRole sysUserRole : sysUserRoles) {
            sysUserRole.setCreateUserId(ShiroUtils.getLoginUserId());
        }

        return sysUserRoleMapper.insertBatchSelective(sysUserRoles) > 0;
    }

    @Override
    public boolean deleteByPk(SysUserRole sysUserRole) {
        return sysUserRoleMapper.deleteByPk(sysUserRole) > 0;
    }

    @Override
    public boolean deleteBatchByUserId(SysUserRole sysUserRole) {
        return sysUserRoleMapper.deleteBatchByUserId(sysUserRole) > 0;
    }

    @Override
    public boolean deleteBatchByRoleId(SysUserRole sysUserRole) {
        return sysUserRoleMapper.deleteBatchByRoleId(sysUserRole) > 0;
    }

}

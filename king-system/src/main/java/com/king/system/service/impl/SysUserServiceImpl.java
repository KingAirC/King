package com.king.system.service.impl;

import com.king.common.util.PrimaryKeyUtils;
import com.king.system.mapper.SysUserMapper;
import com.king.system.pojo.SysUser;
import com.king.system.service.SysUserServiceI;
import com.king.system.util.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserServiceI {

    private SysUserMapper sysUserMapper;

    @Autowired
    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public boolean create(SysUser sysUser) {
        sysUser.setId(PrimaryKeyUtils.uuid());
        sysUser.setCreateUserId(ShiroUtils.getLoginUserId());
        sysUser.setUpdateUserId(sysUser.getCreateUserId());

        return sysUserMapper.insertSelective(sysUser) > 0;
    }

    @Override
    public boolean createBatch(List<SysUser> sysUsers) {
        for (SysUser sysUser : sysUsers) {
            sysUser.setId(PrimaryKeyUtils.uuid());
            sysUser.setCreateUserId(ShiroUtils.getLoginUserId());
            sysUser.setUpdateUserId(sysUser.getCreateUserId());
        }

        return sysUserMapper.insertBatchSelective(sysUsers) > 0;
    }

    @Override
    public boolean deleteByPk(SysUser sysUser) {
        return sysUserMapper.deleteByPk(sysUser) > 0;
    }

    @Override
    public boolean deleteBatch(List<SysUser> sysUsers) {
        return sysUserMapper.deleteBatch(sysUsers) > 0;
    }

    @Override
    public boolean updateByPk(SysUser sysUser) {
        sysUser.setUpdateUserId(ShiroUtils.getLoginUserId());

        return sysUserMapper.updateByPkSelective(sysUser) > 0;
    }

    @Override
    public boolean updateDeleteFlag(SysUser sysUser) {
        sysUser.setUpdateUserId(ShiroUtils.getLoginUserId());

        return sysUserMapper.updateDeleteFlag(sysUser) > 0;
    }

    @Override
    public SysUser read4DetailByPk(SysUser sysUser) {
        return sysUserMapper.select4DetailByPk(sysUser);
    }

    @Override
    public List<SysUser> read4List(SysUser sysUser) {
        return sysUserMapper.select4ListSelective(sysUser);
    }

    @Override
    public int read4Count(SysUser sysUser) {
        return sysUserMapper.select4Count(sysUser);
    }

    @Override
    public int read4NameCount(String username) {
        return sysUserMapper.select4NameCount(username);
    }

    @Override
    public SysUser read4DetailByName(String username) {
        return sysUserMapper.selectDetailByName(username);
    }
}

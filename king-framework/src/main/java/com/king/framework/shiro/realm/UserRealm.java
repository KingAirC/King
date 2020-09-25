package com.king.framework.shiro.realm;

import com.king.system.pojo.SysUser;
import com.king.system.service.SysMenuServiceI;
import com.king.system.service.SysRoleServiceI;
import com.king.system.service.SysUserServiceI;
import com.king.system.util.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class UserRealm extends AuthorizingRealm {

    private SysUserServiceI sysUserService;
    private SysRoleServiceI sysRoleService;
    private SysMenuServiceI sysMenuService;

    @Autowired
    public void setSysUserService(SysUserServiceI sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Autowired
    public void setSysRoleServiceI(SysRoleServiceI sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Autowired
    public void setSysMenuServiceI(SysMenuServiceI sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @Override
    public String getName() {
        return "UserRealm" ;
    }

    /**
     * admin放行
     *
     * @param principals PrincipalCollection
     * @param permission String
     * @return boolean
     */
    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        return ShiroUtils.isAdminUser((SysUser) principals.getPrimaryPrincipal()) ||
                super.isPermitted(principals, permission);
    }

    /**
     * admin放行
     *
     * @param principals     PrincipalCollection
     * @param roleIdentifier String
     * @return boolean
     */
    @Override
    public boolean hasRole(PrincipalCollection principals, String roleIdentifier) {
        return ShiroUtils.isAdminUser((SysUser) principals.getPrimaryPrincipal()) ||
                super.hasRole(principals, roleIdentifier);
    }

    /**
     * 授权
     *
     * @param principals PrincipalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = ShiroUtils.getShiroUser();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        if (ShiroUtils.isAdminUser(sysUser)) {
            simpleAuthorizationInfo.addRole("1");
            simpleAuthorizationInfo.addStringPermission("*:*:*");
        } else {
            simpleAuthorizationInfo.setRoles(
                    new HashSet<>(sysRoleService.read4SysRoleNameListBySysUserName(sysUser)));
            simpleAuthorizationInfo.setStringPermissions(
                    new HashSet<>(sysMenuService.read4PermissionListBySysUserLoginName(sysUser)));
        }

        return simpleAuthorizationInfo;
    }

    /**
     * 认证，登录
     *
     * @param token AuthenticationToken
     * @return AuthenticationInfo
     * @throws AuthenticationException AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();

        if (sysUserService.read4NameCount(username) == 0) {
            return null;
        }

        SysUser sysUser = sysUserService.read4DetailByName(username);

        return new SimpleAuthenticationInfo(
                sysUser,
                sysUser.getPasswordEncrypt(),
                ByteSource.Util.bytes(sysUser.getSalt()),
                getName());
    }
}

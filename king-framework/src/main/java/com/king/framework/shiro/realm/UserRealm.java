package com.king.framework.shiro.realm;

import com.king.system.pojo.SysUser;
import com.king.system.service.SysMenuServiceI;
import com.king.system.service.SysRoleServiceI;
import com.king.system.service.SysUserServiceI;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        return "UserRealm";
    }

    /**
     * 授权
     *
     * @param principals PrincipalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.iterator().next();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 查询当前用户所具有的角色
        List<String> roleNameListByShiroUserName = sysRoleService.read4SysRoleNameListBySysUserName(sysUser);
        Set<String> roles = new HashSet<>(roleNameListByShiroUserName);
        simpleAuthorizationInfo.setRoles(roles);

        // 查询当前用户所具有的权限
        List<String> permissionList = sysMenuService.read4PermissionListBySysUserLoginName(sysUser);
        Set<String> stringPermissions = new HashSet<>(permissionList);
        simpleAuthorizationInfo.setStringPermissions(stringPermissions);

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

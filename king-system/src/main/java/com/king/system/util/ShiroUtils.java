package com.king.system.util;

import com.king.system.pojo.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

public class ShiroUtils {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static void logout() {
        getSubject().logout();
    }

    public static SysUser getShiroUser() {
        SysUser user = null;
        Object obj = getSubject().getPrincipal();
        if (obj != null) {
            user = new SysUser();

            try {
                BeanUtils.copyProperties(obj, user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static void setShiroUser(SysUser user) {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        subject.runAs(newPrincipalCollection);
    }

    public static String getLoginUserId() {
        return getShiroUser().getId();
    }

    public static String getLoginUserName() {
        return getShiroUser().getLoginName();
    }

    public static boolean isAdminUser(SysUser sysUser) {
        return "1".equals(sysUser.getId());
    }

}

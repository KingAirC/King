package com.king.admin.controller.system;

import com.king.common.core.domain.AjaxResult;
import com.king.common.util.PasswordUtils;
import com.king.common.util.RandomUtils;
import com.king.system.pojo.SysUser;
import com.king.system.service.SysUserServiceI;
import com.king.system.util.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/system/login")
public class SysLoginController {

    private SysUserServiceI sysUserService;

    @Autowired
    public void setSysUserService(SysUserServiceI sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping("/to/login")
    public String toLogin() {
        return "/admin/login";
    }

    @RequestMapping("/login")
    public String login(SysUser sysUser, Model model) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getLoginName(), sysUser.getPasswordText());

        try {
            subject.login(usernamePasswordToken);

            return "redirect:/admin/system/index/index";
        } catch (UnknownAccountException unknownAccountException) {
            model.addAttribute("msg", "用户名不存在");

            return "/admin/login";
        } catch (IncorrectCredentialsException incorrectCredentialsException) {
            model.addAttribute("msg", "密码错误");

            return "/admin/login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {

        ShiroUtils.logout();

        return "/admin/login";
    }

    @RequestMapping("/to/user/setting")
    public String toUserSetting(Model model) {
        model.addAttribute("user", ShiroUtils.getShiroUser());

        return "/admin/setting";
    }

    @RequestMapping("/to/user/password")
    public String toUserPassword() {
        return "/admin/password";
    }

    @ResponseBody
    @RequestMapping("/update/user/password")
    public AjaxResult updateUserPassword(SysUser sysUser, String old_password) {
        sysUser.setId(ShiroUtils.getLoginUserId());

        SysUser read = sysUserService.read4DetailByPk(sysUser);

        if (!read.getPasswordEncrypt().equals(PasswordUtils.encrypt(old_password, read.getSalt()))) {
            return new AjaxResult(1, "旧密码输入错误", null);
        }

        sysUser.setSalt(RandomUtils.random());
        sysUser.setPasswordEncrypt(PasswordUtils.encrypt(sysUser.getPasswordText(), sysUser.getSalt()));

        boolean updateShiroUser = sysUserService.updateByPk(sysUser);

        if (updateShiroUser) {
            ShiroUtils.setShiroUser(sysUser);

            return new AjaxResult(0, "修改密码成功", null);
        } else {
            return new AjaxResult(1, "修改密码错误", null);
        }
    }

}

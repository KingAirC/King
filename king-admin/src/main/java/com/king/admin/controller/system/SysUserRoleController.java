package com.king.admin.controller.system;

import com.king.system.pojo.SysRoleMenu;
import com.king.system.service.SysRoleMenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/system/user/role")
public class SysUserRoleController {

    private SysRoleMenuServiceI sysRoleMenuService;

    @Autowired
    public void setSysRoleMenuService(SysRoleMenuServiceI sysRoleMenuService) {
        this.sysRoleMenuService = sysRoleMenuService;
    }

    @ResponseBody
    @PostMapping("/add")
    public boolean add(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.create(sysRoleMenu);
    }

    @ResponseBody
    @PostMapping("/add/batch")
    public boolean addBatch(List<SysRoleMenu> sysRoleMenus) {
        return sysRoleMenuService.createBatch(sysRoleMenus);
    }

    @ResponseBody
    @PostMapping("/delete/by/pk")
    public boolean deleteByPk(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.deleteByPk(sysRoleMenu);
    }

    @ResponseBody
    @PostMapping("/delete/batch/by/menuId")
    public boolean deleteBatchByMenuId(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.deleteBatchByMenuId(sysRoleMenu);
    }

    @ResponseBody
    @PostMapping("/delete/batch/by/roleId")
    public boolean deleteBatchByRoleId(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.deleteBatchByRoleId(sysRoleMenu);
    }

}

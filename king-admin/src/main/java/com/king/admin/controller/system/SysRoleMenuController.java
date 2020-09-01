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
@RequestMapping("/admin/system/role/menu")
public class SysRoleMenuController {

    private SysRoleMenuServiceI sysRoleMenuService;

    @Autowired
    public void setSysRoleMenuService(SysRoleMenuServiceI sysRoleMenuService) {
        this.sysRoleMenuService = sysRoleMenuService;
    }

    /**
     * 添加
     *
     * @param sysRoleMenu pojo
     * @return 是否添加成功
     */
    @ResponseBody
    @PostMapping("/add")
    public boolean add(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.create(sysRoleMenu);
    }

    /**
     * 批量添加
     *
     * @param sysRoleMenus List
     * @return 是否添加成功
     */
    @ResponseBody
    @PostMapping("/add/batch")
    public boolean addBatch(List<SysRoleMenu> sysRoleMenus) {
        return sysRoleMenuService.createBatch(sysRoleMenus);
    }

    /**
     * 根据主键删除
     *
     * @param sysRoleMenu pojo
     * @return 是否删除成功
     */
    @ResponseBody
    @PostMapping("/delete/by/pk")
    public boolean deleteByPk(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.deleteByPk(sysRoleMenu);
    }

    /**
     * 根据menuId批量删除
     *
     * @param sysRoleMenu pojo
     * @return 是否删除成功
     */
    @ResponseBody
    @PostMapping("/delete/batch/by/menuId")
    public boolean deleteBatchByMenuId(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.deleteBatchByMenuId(sysRoleMenu);
    }

    /**
     * 根据roleId批量删除
     *
     * @param sysRoleMenu pojo
     * @return 是否删除成功
     */
    @ResponseBody
    @PostMapping("/delete/batch/by/roleId")
    public boolean deleteBatchByRoleId(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuService.deleteBatchByRoleId(sysRoleMenu);
    }

}

package com.king.admin.controller.system;

import com.king.system.pojo.SysMenu;
import com.king.system.service.SysMenuServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/system/menu")
public class SysMenuController {

    private SysMenuServiceI sysMenuService;

    @Autowired
    public void setSysMenuService(SysMenuServiceI sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    /**
     * 左侧菜单显示
     *
     * @return List
     */
    @ResponseBody
    @RequestMapping("/menu")
    public List<SysMenu> menu() {
        return sysMenuService.read4DirAndMenuList();
    }

    /**
     * 查询全部
     *
     * @return List
     */
    @ResponseBody
    @RequestMapping("/menu/all")
    public List<SysMenu> menuAll() {
        return sysMenuService.read4List();
    }

    /**
     * 路由到菜单管理页面
     *
     * @return List
     */
    @RequestMapping("/to/menu/mng")
    public String toMenuMngPage(Model model) {
        model.addAttribute("menu", sysMenuService.read4List());

        return "/admin/system/menu/menu";
    }

    /**
     * 路由到添加页面
     *
     * @return 页面
     */
    @GetMapping("/add")
    public String add() {
        return "";
    }

    /**
     * 路由到更新页面
     *
     * @return 页面
     */
    @GetMapping("/update")
    public String update(Model model) {
        return "";
    }

    /**
     * 路由到详细页面
     *
     * @return 页面
     */
    @GetMapping("/detail")
    public String detail(Model model) {
        return "";
    }

    /**
     * 添加
     *
     * @param sysMenu pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/add")
    public boolean add(SysMenu sysMenu) {
        return sysMenuService.create(sysMenu);
    }

    /**
     * 批量添加
     *
     * @param sysMenus List
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/add/batch")
    public boolean addBatch(List<SysMenu> sysMenus) {
        return sysMenuService.createBatch(sysMenus);
    }

    /**
     * 根据主键删除
     *
     * @param sysMenu pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/delete/by/pk")
    public boolean deleteByPk(SysMenu sysMenu) {
        return sysMenuService.deleteByPk(sysMenu);
    }

    /**
     * 批量删除
     *
     * @param sysMenus List
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/delete/batch")
    public boolean deleteBatch(List<SysMenu> sysMenus) {
        return sysMenuService.deleteBatch(sysMenus);
    }

    /**
     * 更新
     *
     * @param sysMenu pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/update/by/pk")
    public boolean updateByPk(SysMenu sysMenu) {
        return sysMenuService.updateByPk(sysMenu);
    }

    /**
     * 启用禁用
     *
     * @param sysMenu pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/update/deleteFlag")
    public boolean updateDeleteFlag(SysMenu sysMenu) {
        return sysMenuService.updateDeleteFlag(sysMenu);
    }

    /**
     * 根据主键查询详细
     *
     * @param sysMenu pojo
     * @return pojo
     */
    @ResponseBody
    @PostMapping("/read/detail")
    public SysMenu read4DetailByPk(SysMenu sysMenu) {
        return sysMenuService.read4DetailByPk(sysMenu);
    }

    /**
     * 条件查询
     *
     * @param sysMenu pojo
     * @return List
     */
    @ResponseBody
    @PostMapping("/read/list")
    public List<SysMenu> read4List(SysMenu sysMenu) {
        return sysMenuService.read4List(sysMenu);
    }

    /**
     * 唯一性验证
     *
     * @param sysMenu pojo
     * @return 是否唯一
     */
    @ResponseBody
    @PostMapping("/unique")
    public boolean isUnique(SysMenu sysMenu) {
        return sysMenuService.read4Count(sysMenu) == 0;
    }

}

package com.king.admin.controller.system;

import com.github.pagehelper.PageHelper;
import com.king.common.constant.Constants;
import com.king.common.core.domain.AjaxResult;
import com.king.system.pojo.SysRole;
import com.king.system.pojo.SysUser;
import com.king.system.service.SysRoleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/system/role")
public class SysRoleController {

    private SysRoleServiceI sysRoleService;

    @Autowired
    public void setSysRoleServiceI(SysRoleServiceI sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    /**
     * 路由到显示页面
     *
     * @return 页面
     */
    @GetMapping("")
    public String index() {
        return "/admin/system/role/role";
    }

    @ResponseBody
    @RequestMapping("/list/page")
    public AjaxResult list4Page(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = Constants.DEFAULT_PAGE_SIZE) int limit,
                                SysRole sysRole) {
        PageHelper.startPage(page, limit);

        AjaxResult ajaxResult = new AjaxResult(sysRoleService.read4List(sysRole));
        ajaxResult.put("count", sysRoleService.read4Count(sysRole));

        return ajaxResult;
    }

    /**
     * 路由到添加页面
     *
     * @return 页面
     */
    @GetMapping("/add")
    public String add() {
        return "/admin/system/role/add";
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
     * @param sysRole pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/add")
    public boolean add(SysRole sysRole) {
        return sysRoleService.create(sysRole);
    }

    /**
     * 批量添加
     *
     * @param sysRoles List
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/add/batch")
    public boolean addBatch(List<SysRole> sysRoles) {
        return sysRoleService.createBatch(sysRoles);
    }

    /**
     * 根据主键删除
     *
     * @param sysRole pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/delete/by/pk")
    public boolean deleteByPk(SysRole sysRole) {
        return sysRoleService.deleteByPk(sysRole);
    }

    /**
     * 批量删除
     *
     * @param sysRoles List
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/delete/batch")
    public boolean deleteBatch(List<SysRole> sysRoles) {
        return sysRoleService.deleteBatch(sysRoles);
    }

    /**
     * 更新
     *
     * @param sysRole pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/update/by/pk")
    public boolean updateByPk(SysRole sysRole) {
        return sysRoleService.updateByPk(sysRole);
    }

    /**
     * 启用禁用
     *
     * @param sysRole pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/update/deleteFlag")
    public boolean updateDeleteFlag(SysRole sysRole) {
        return sysRoleService.updateDeleteFlag(sysRole);
    }

    /**
     * 根据主键查询详细
     *
     * @param sysRole pojo
     * @return pojo
     */
    @ResponseBody
    @PostMapping("/read/detail/by/pk")
    public SysRole read4DetailByPk(SysRole sysRole) {
        return sysRoleService.read4DetailByPk(sysRole);
    }

    /**
     * 条件查询
     *
     * @param sysRole pojo
     * @return List
     */
    @ResponseBody
    @PostMapping("/read/list")
    public List<SysRole> read4List(SysRole sysRole) {
        return sysRoleService.read4List(sysRole);
    }

    /**
     * 唯一性验证
     *
     * @param sysRole pojo
     * @return 是否唯一
     */
    @ResponseBody
    @PostMapping("/unique")
    public boolean isUnique(SysRole sysRole) {
        return sysRoleService.read4Count(sysRole) == 0;
    }

}

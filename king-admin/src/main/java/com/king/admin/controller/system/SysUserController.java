package com.king.admin.controller.system;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.king.common.constant.Constants;
import com.king.common.core.domain.AjaxResult;
import com.king.system.pojo.SysUser;
import com.king.system.service.SysUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/system/user")
public class SysUserController {

    private SysUserServiceI sysUserService;

    @Autowired
    public void setSysUserService(SysUserServiceI sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 路由到显示页面
     *
     * @return 页面
     */
    @GetMapping("")
    public String index() {
        return "/admin/system/user/user";
    }

    /**
     * 路由到添加页面
     *
     * @return 页面
     */
    @GetMapping("/add")
    public String add() {
        return "/admin/system/user/add";
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
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);

        model.addAttribute("shiroUserDetail", sysUserService.read4DetailByPk(sysUser));

        return "/admin/system/user/detail";
    }

    /**
     * 添加
     *
     * @param shiroUser pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/add")
    public boolean add(SysUser shiroUser) {
        return sysUserService.create(shiroUser);
    }

    /**
     * 批量添加
     *
     * @param sysUsers List
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/add/batch")
    public boolean addBatch(List<SysUser> sysUsers) {
        return sysUserService.createBatch(sysUsers);
    }

    /**
     * 根据主键删除
     *
     * @param sysUser pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/delete")
    public boolean delete(SysUser sysUser) {
        return sysUserService.deleteByPk(sysUser);
    }

    /**
     * 批量删除
     *
     * @param shiroUsers List
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/delete/batch")
    public boolean deleteBatch(String shiroUsers) {
        return sysUserService.deleteBatch(JSON.parseArray(shiroUsers, SysUser.class));
    }

    /**
     * 更新
     *
     * @param sysUser pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/update/by/pk")
    public boolean updateByPk(SysUser sysUser) {
        return sysUserService.updateByPk(sysUser);
    }

    /**
     * 启用禁用
     *
     * @param sysUser pojo
     * @return 是否成功
     */
    @ResponseBody
    @PostMapping("/update/deleteFlag")
    public boolean updateDeleteFlag(SysUser sysUser) {
        return sysUserService.updateDeleteFlag(sysUser);
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        SysUser shiroUser = new SysUser();
        shiroUser.setId(id);

        model.addAttribute("shiroUserDetail", sysUserService.read4DetailByPk(shiroUser));

        return "/admin/system/user/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public boolean edit(SysUser shiroUser) {
        return sysUserService.updateByPk(shiroUser);
    }

    /**
     * 根据主键查询详细
     *
     * @param sysUser pojo
     * @return pojo
     */
    @ResponseBody
    @PostMapping("/read/detail/by/pk")
    public SysUser read4DetailByPk(SysUser sysUser) {
        return sysUserService.read4DetailByPk(sysUser);
    }

    /**
     * 条件查询
     *
     * @param sysUser pojo
     * @return List
     */
    @ResponseBody
    @PostMapping("/list")
    public List<SysUser> read4List(SysUser sysUser) {
        return sysUserService.read4List(sysUser);
    }

    @ResponseBody
    @RequestMapping("/list/page")
    public AjaxResult list4Page(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = Constants.DEFAULT_PAGE_SIZE) int limit,
                                SysUser shiroUser) {
        PageHelper.startPage(page, limit);

        AjaxResult ajaxResult = new AjaxResult(sysUserService.read4List(shiroUser));
        ajaxResult.put("count", sysUserService.read4Count(shiroUser));

        return ajaxResult;
    }

    @ResponseBody
    @PostMapping("/detail")
    public SysUser detail(SysUser shiroUser) {
        return sysUserService.read4DetailByPk(shiroUser);
    }

    /**
     * 唯一性验证
     *
     * @param sysUser pojo
     * @return 是否唯一
     */
    @ResponseBody
    @PostMapping("/unique")
    public boolean isUnique(SysUser sysUser) {
        return sysUserService.read4Count(sysUser) == 0;
    }

}

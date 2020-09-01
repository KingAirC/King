package com.king.generator.controller;

import com.github.pagehelper.PageHelper;
import com.king.common.constant.Constants;
import com.king.common.core.domain.AjaxResult;
import com.king.generator.pojo.MysqlTable;
import com.king.generator.service.GeneratorServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/system/generator")
public class GenerateController {

    private GeneratorServiceI generatorService;

    @Autowired
    public void setGeneratorService(GeneratorServiceI generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping("")
    public String index() {
        return "/generator/generator";
    }

    @ResponseBody
    @RequestMapping("/list/page")
    public AjaxResult list4Page(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = Constants.DEFAULT_PAGE_SIZE) int limit,
                                MysqlTable mysqlTable) {
        PageHelper.startPage(page, limit);

        List<MysqlTable> mysqlTableList = generatorService.read4MysqlTable(mysqlTable);
        int count = generatorService.select4TableCount(mysqlTable);

        AjaxResult ajaxResult = new AjaxResult(mysqlTableList);
        ajaxResult.put("count", count);

        return ajaxResult;
    }

    @RequestMapping("/gen")
    public void generate(String tableName) {
        generatorService.generate(tableName);
    }

}

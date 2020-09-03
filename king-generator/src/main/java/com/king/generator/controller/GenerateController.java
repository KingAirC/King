package com.king.generator.controller;

import com.github.pagehelper.PageHelper;
import com.king.common.constant.Constants;
import com.king.common.core.domain.AjaxResult;
import com.king.generator.pojo.GenTable;
import com.king.generator.service.GeneratorServiceI;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                                GenTable genTable) {
        PageHelper.startPage(page, limit);

        List<GenTable> genTableList = generatorService.read4GenTable(genTable);
        int count = generatorService.select4TableCount(genTable);

        AjaxResult ajaxResult = new AjaxResult(genTableList);
        ajaxResult.put("count", count);

        return ajaxResult;
    }

    @GetMapping("/genCode/{tableName}")
    public void genCode(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
        byte[] data = generatorService.generatorCode(tableName);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"king.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

}

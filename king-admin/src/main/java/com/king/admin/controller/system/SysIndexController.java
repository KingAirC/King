package com.king.admin.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/system/index")
public class SysIndexController {

    @RequestMapping("/index")
    public String index() {
        return "/admin/index";
    }

}

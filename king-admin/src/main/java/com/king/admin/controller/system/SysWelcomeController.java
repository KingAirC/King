package com.king.admin.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/system/welcome")
public class SysWelcomeController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "/admin/welcome";
    }

}

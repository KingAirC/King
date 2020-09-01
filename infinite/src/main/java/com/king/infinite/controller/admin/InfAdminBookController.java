package com.king.infinite.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/inf/book")
public class InfAdminBookController {

    @RequestMapping("/index")
    public String index() {
        return "/infinite/admin/book/index";
    }
}

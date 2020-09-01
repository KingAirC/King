package com.king.pass.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pass/index")
public class PassIndexController {

    @RequestMapping("/index")
    public String index() {
        return "";
    }
}

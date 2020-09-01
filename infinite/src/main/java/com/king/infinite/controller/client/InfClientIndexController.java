package com.king.infinite.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/infinite/index")
public class InfClientIndexController {

    @GetMapping("/index")
    public String index() {
        return "/infinite/client/index";
    }
}

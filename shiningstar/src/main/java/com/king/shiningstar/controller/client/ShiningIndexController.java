package com.king.shiningstar.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shining/index")
public class ShiningIndexController {

    @GetMapping("/index")
    public String index() {
        return "";
    }
}

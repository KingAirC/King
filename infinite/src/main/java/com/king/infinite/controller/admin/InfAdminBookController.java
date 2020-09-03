package com.king.infinite.controller.admin;

import com.king.common.config.file.FileUploadPathConfig;
import com.king.common.util.file.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/inf/book")
public class InfAdminBookController {

    @RequestMapping("/index")
    public String index() {
        return "/infinite/admin/book/index";
    }

    @ResponseBody
    @PostMapping("/up")
    public boolean up(MultipartFile file) {

        String dir = FileUploadPathConfig.getPdf();

        String fileName = FileUploadUtils.upload(dir, file);



        return false;
    }

}

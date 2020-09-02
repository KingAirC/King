package com.king.common.util.file;

import com.king.common.util.PrimaryKeyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadUtils {

    /**
     * 文件上传
     *
     * @param baseDir 文件目录
     * @param file    文件
     * @return 文件存储名
     */
    public static String upload(String baseDir, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String fileNameStorage = PrimaryKeyUtils.uuidClean() + "-" + file.getOriginalFilename();
        File dest = new File(baseDir, fileNameStorage);

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileNameStorage;
    }
}

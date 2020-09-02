package com.king.common.config.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file-upload-path")
@PropertySource(value = {"classpath:common.yml"})
@EnableAutoConfiguration
public class FileUploadPathConfig {

    private static String pdf;

    public static String getPdf() {
        return pdf;
    }

    @Value("${pdf}")
    private void setPackageName(String pdf) {
        FileUploadPathConfig.pdf = pdf;
    }

}

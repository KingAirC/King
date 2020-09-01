package com.king.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.king.**.mapper")
public class ApplicationConfig {

}

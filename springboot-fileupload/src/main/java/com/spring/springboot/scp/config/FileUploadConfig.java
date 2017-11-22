/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.config;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.MultipartConfigElement;

/**
 * FileUploadConfig
 * 文件上传的配置类
 * @author 萝卜丝
 * @since 2017-09-15
 */
@Component
@Configuration
public class FileUploadConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制，超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了
        factory.setMaxFileSize("1280KB");// KB，MB
        // 设置总上传数据总大小
        factory.setMaxRequestSize("2560KB");
        // 设置文件存储的路径
        // factory.setLocation("./");
        return factory.createMultipartConfig();
    }
}
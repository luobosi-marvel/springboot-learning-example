/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.springboot.apollo.config;

import com.thetransactioncompany.cors.CORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * GlobalConfig
 *
 * @author 萝卜丝
 * @since 2017-11-11
 */
@Configuration
public class GlobalConfig {

    /**
     * filter - addCORS
     *
     * 关于跨域问题的配置
     */
    @Bean
    public FilterRegistrationBean addCORSFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CORSFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;
    }

    /**
     * filter - addCharacterEncoding
     *
     * 关于全局字符处理器的配置
     */
    @Bean
    public FilterRegistrationBean addCharacterEncodingFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CharacterEncodingFilter());
        registration.addInitParameter("encoding", "UTF-8");
        registration.addInitParameter("forceEncoding", "UTF-8");
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.config;

import com.spring.springboot.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * GlobalConfig
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-13
 */
@Configuration
public class GlobalConfig extends WebMvcConfigurerAdapter {

    /**
     * filter - addToken
     */
/*    @Bean
    public FilterRegistrationBean addTokenFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TokenFilter());
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;
    }*/
}
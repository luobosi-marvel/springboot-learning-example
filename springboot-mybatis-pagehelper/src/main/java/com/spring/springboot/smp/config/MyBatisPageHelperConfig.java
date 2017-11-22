/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * MyBatisPageHelperConfig
 * MyBatis 分页插件配置类
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Configuration
public class MyBatisPageHelperConfig {

    /**
     * 配置mybatis的分页插件pageHelper
     *
     * @return 返回分页插件
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        // 设置 mysql 数据库方言
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);

        return pageHelper;
    }
}
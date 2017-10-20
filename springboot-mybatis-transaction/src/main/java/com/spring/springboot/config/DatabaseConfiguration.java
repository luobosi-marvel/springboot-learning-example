/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


/**
 * DatabaseConfiguration
 *
 * @author 萝卜丝
 * @since 2017-10-11
 */
@Configuration
public class DatabaseConfiguration {


    @Bean
    public PlatformTransactionManager transactionManager2(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
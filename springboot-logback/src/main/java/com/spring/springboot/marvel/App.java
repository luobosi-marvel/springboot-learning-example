/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.marvel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * App
 *
 * @author 萝卜丝
 * @since 2017-09-19
 */
public class App {
    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");
    }

}
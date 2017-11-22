/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.spring.springboot.scp.bean.RocketmqProperties.PREFIX;

/**
 * RocketmqProperties
 *
 * @author 萝卜丝
 * @since 2017-09-11
 */
@Data
@ConfigurationProperties(PREFIX)
public class RocketmqProperties {

    public static final String PREFIX = "spring.extend.rocketmq";

    private String namesrvAddr;
    private String instanceName;
    private String clientIP;

}
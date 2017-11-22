/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.bean;

import lombok.Data;

/**
 * Account
 *
 * @author 萝卜丝
 * @since 2017-10-21
 */
@Data
public class Account {

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Integer accountState;
}
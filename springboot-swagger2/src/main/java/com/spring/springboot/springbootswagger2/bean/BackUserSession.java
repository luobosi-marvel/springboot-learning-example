/*
 * Copyright (C) 2009-2018 Hangzhou Iroly Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Date: 2019-02-24
 * Time: 18:30
 * Description: 后台用户session信息
 *
 * @author qiezi
 */
@Data
public class BackUserSession implements Serializable {

    private static final long serialVersionUID = -5433450626488045238L;

    /**
     * 是否管理员
     */
    private Boolean isAdmin;

    /**
     * 用户token
     */
    private String authorization;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户id
     */
    private Integer userId;

}


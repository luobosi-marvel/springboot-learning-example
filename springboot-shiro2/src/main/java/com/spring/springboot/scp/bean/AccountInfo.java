/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.bean;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * AccountInfo
 *
 * @author 萝卜丝
 * @since 2017-10-23
 */
@Data
@ToString
public class AccountInfo implements Serializable{

    private static final long serialVersionUID = 5051347956763834501L;

    /**
     * token 信息
     */
    private String token;

    /**
     * 用户id
     */
    private String accountId;

    /**
     * 用户名
     */
    private String username;
}
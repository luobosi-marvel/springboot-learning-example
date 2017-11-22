/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * User
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */

@Data
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private String password;

    private Integer age;

    private Date startTime;

}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.domain;

import lombok.Data;

/**
 * User
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */

@Data
public class User {

    private Long id;

    private String name;

    private String password;

    private Integer age;

}
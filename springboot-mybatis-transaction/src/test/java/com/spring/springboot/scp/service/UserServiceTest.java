/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.service;

import org.junit.Test;

import javax.annotation.Resource;

/**
 * UserServiceTest
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
public class UserServiceTest {

    @Resource
    private UserService userServiceImpl;

    @Test
    public void insert() {
        System.out.println(userServiceImpl);
/*        User user = new User();
        user.setId(1236536L);
        user.setName("marvel");
        user.setPassword(UUID.randomUUID().toString());
        user.setAge(22);
        userService.insert(user);*/
    }
}
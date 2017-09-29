/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * ShiroStartTest
 *
 * @author 萝卜丝
 * @since 2017-09-18
 */
@RunWith(SpringRunner.class)
public class ShiroStartTest {

    @Resource
    private SessionManager sessionManager;
    @Test
    public void testHasRole() {
        System.out.println(sessionManager);
    }
}
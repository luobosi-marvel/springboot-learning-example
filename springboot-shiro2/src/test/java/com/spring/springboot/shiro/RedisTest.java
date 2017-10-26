/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.shiro;

import com.spring.springboot.BaseTest;
import com.spring.springboot.dao.RedisSessionDAO;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * RedisTest
 *
 * @author 萝卜丝
 * @since 2017-10-24
 */
public class RedisTest extends BaseTest{

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisSessionDAO redisSessionDAO;



    @Test
    public void test() {
        System.out.println(redisTemplate);
    }

    @Test
    public void testRedisSessionDAO() {
        Session session = this.redisSessionDAO.readSession("k1");
        Assert.assertNotNull(session);
    }
}
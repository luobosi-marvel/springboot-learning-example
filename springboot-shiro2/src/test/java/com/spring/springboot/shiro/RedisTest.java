/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.shiro;

import com.spring.springboot.BaseTest;
import com.spring.springboot.bean.AccountInfo;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * RedisTest
 *
 * @author 萝卜丝
 * @since 2017-10-24
 */
public class RedisTest extends BaseTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        System.out.println(redisTemplate);
    }

    @Test
    public void testRedisSessionDAO() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setToken("123");
        accountInfo.setAccountId("1243");
        accountInfo.setUsername("隔壁老王");
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello", accountInfo);
        System.out.println("useRedisDao = " + valueOperations.get("hello"));

    }
}
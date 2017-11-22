/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.dao;

import com.spring.springboot.BaseTest;
import com.spring.springboot.domain.User;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * UserDAOTest
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
public class UserDAOTest extends BaseTest {

    @Resource
    private UserDAO userDAO;

    @Test
    public void testFindByName() {
        System.out.println(userDAO.findByName("marvel"));
    }

    @Test
    public void testInsert() {
       //userDAO.insert(new User(1236537L, "single", UUID.randomUUID().toString(), 22, new Date()));
       //userDAO.insert(new User(1236538L, "jane", UUID.randomUUID().toString(), 22, new Date()));
       //userDAO.insert(new User(1236539L, "blue", UUID.randomUUID().toString(), 22, new Date()));
       //userDAO.insert(new User(12365310L, "red", UUID.randomUUID().toString(), 22, new Date()));
       userDAO.insert(new User(12365311L, "yellow", UUID.randomUUID().toString(), 22, new Date()));

    }

    @Test
    public void test() {
        Assert.assertNull("该对象为 null", null);
    }

    @Test
    public void tset1() {
        System.out.println(System.currentTimeMillis());
    }
}
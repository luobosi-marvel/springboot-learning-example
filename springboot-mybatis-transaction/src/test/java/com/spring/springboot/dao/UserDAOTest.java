/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.dao;

import com.spring.springboot.BaseTest;
import com.spring.springboot.domain.User;
import org.junit.Test;

import javax.annotation.Resource;
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
/*        User user = new User();
        user.setId(1236536L);
        user.setName("marvel");
        user.setPassword(UUID.randomUUID().toString());
        user.setAge(22);
        userDAO.insert(user);*/
    }

}
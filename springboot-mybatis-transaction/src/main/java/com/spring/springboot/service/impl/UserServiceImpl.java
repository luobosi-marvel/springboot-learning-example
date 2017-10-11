/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.service.impl;

import com.spring.springboot.dao.UserDAO;
import com.spring.springboot.domain.User;
import com.spring.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserServiceImpl
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public User login(String name, String password) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }
}
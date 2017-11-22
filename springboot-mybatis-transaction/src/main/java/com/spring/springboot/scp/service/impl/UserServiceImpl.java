/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.service.impl;

import com.spring.springboot.scp.dao.UserDAO;
import com.spring.springboot.scp.domain.User;
import com.spring.springboot.scp.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public int insert(User user) {
        return userDAO.insert(user);
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.service;

import com.spring.springboot.domain.User;

/**
 * UserService
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
public interface UserService {

    User login(String name, String password);


    /**
     * 根据名字查找用户信息
     *
     * @param name 用户名
     * @return 返回用户信息
     */
    User findByName(String name);


    /**
     * 插入一条用户信息
     *
     * @param user 用户实体
     * @return 成功返回1
     */
    int insert(User user);
}
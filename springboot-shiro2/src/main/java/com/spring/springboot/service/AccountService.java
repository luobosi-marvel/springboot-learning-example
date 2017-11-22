/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.service;

import com.spring.springboot.bean.Account;
import com.spring.springboot.dao.AccountDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * AccountService
 *
 * @author 萝卜丝
 * @since 2017-10-21
 */
@Service
public class AccountService {

    @Resource
    private AccountDAO accountDAO;

    /**
     * 根据用户名查找用户信息
     *
     * @param username 用户名
     * @return 找到之后的对象
     */
    public Account findAccount(String username) {
        return this.accountDAO.findByName(username);
    }
}
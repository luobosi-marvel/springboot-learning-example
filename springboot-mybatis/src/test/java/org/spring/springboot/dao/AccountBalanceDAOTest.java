/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao;

import org.spring.springboot.BaseTest;

import javax.annotation.Resource;

/**
 * AccountBalanceDAOTest
 *
 * @author 萝卜丝
 * @since 2017-10-24
 */
public class AccountBalanceDAOTest extends BaseTest{

    @Resource
    private AccountBalanceDAO accountBalanceDAO;

    //@Test
    public void test() {
        accountBalanceDAO.get();
    }

}
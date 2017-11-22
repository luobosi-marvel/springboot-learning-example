/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.shiro;

import com.spring.springboot.scp.BaseTest;
import com.spring.springboot.scp.bean.Account;
import com.spring.springboot.scp.dao.AccountDAO;
import com.spring.springboot.scp.util.MD5Util;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * ShiroStartTest
 *
 * @author 萝卜丝
 * @since 2017-09-18
 */
public class ShiroStartTest extends BaseTest {

    @Resource
    private AccountDAO accountDAO;

    @Test
    public void testInsert() {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setName("luobosi");
        account.setPassword(MD5Util.MD5("123456"));
        account.setAccountState(0);

        accountDAO.insert(account);
    }

    @Test
    public void testFindByName() {
        System.out.println(this.accountDAO.findByName("aa"));
    }

}
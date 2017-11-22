/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.dao;

import com.spring.springboot.smp.dao.mapper.AccountMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * AccountDAO
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Repository
public class AccountDAO {

    @Resource
    private AccountMapper accountMapper;
}
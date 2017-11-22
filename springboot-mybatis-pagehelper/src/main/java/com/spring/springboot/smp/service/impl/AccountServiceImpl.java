/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.service.impl;

import com.github.pagehelper.PageHelper;
import com.spring.springboot.smp.domain.AccountDO;
import com.spring.springboot.smp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Override
    public List<AccountDO> findAccountByPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return null;
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.mapper;

import com.spring.springboot.smp.domain.AccountDO;

/**
 * AccountMapper
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public interface AccountMapper {

    int insert(AccountDO accountDO);

    int update(AccountDO accountDO);

    int delete(String accountId);
}
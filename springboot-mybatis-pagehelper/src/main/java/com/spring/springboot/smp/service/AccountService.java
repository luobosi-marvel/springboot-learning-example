/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.service;

import com.spring.springboot.smp.domain.AccountDO;

import java.util.List;

/**
 * AccountService
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public interface AccountService {

    /**
     * 分页查找用户信息
     *
     * @param currentPage   当前页
     * @param pageSize      页面总大小
     * @return              根据分页查找到的结果
     */
    List<AccountDO> findAccountByPage(Integer currentPage, Integer pageSize);

}
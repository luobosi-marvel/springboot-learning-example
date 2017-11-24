/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.service.impl;

import com.spring.springboot.dto.AccountDTO;
import com.spring.springboot.service.AccountService;
import com.spring.springboot.vo.AccountVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public long getPageCounts() {
        return 0;
    }

    @Override
    public List<AccountVO> findAll(AccountDTO accountDTO) {
        return null;
    }
}
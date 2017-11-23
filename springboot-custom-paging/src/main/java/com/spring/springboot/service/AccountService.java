/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.service;

import com.spring.springboot.dto.AccountDTO;
import com.spring.springboot.vo.AccountVO;

import java.util.List;

/**
 * AccountService
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public interface AccountService {

    /**
     * 获取总记录数
     *
     * @return 总记录数
     */
    long getPageCounts();

    /**
     * 查找用户信息
     *
     * @return VO 类
     */
    List<AccountVO> findAll(AccountDTO accountDTO);
}
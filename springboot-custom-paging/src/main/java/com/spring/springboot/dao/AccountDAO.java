/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.dao;

import com.spring.springboot.domain.AccountDO;
import com.spring.springboot.mapper.AccountMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 获取总纪录数
     *
     * @return 总纪录数
     */
    public long getPageCounts() {
        return this.accountMapper.getPageCounts();
    }

    /**
     * 查找用户信息
     *
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return           用户集合类
     */
    public List<AccountDO> findAccounts(int startIndex, int endIndex) {
        // 参数校验
        return this.accountMapper.findAccounts(startIndex, endIndex);
    }

}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.dao;

import com.spring.springboot.smp.dao.mapper.AccountMapper;
import com.spring.springboot.smp.domain.AccountDO;
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
     * 插入一个用户
     *
     * @param accountDO 用户实体
     * @return  影响的记录数
     */
    public int insert(AccountDO accountDO) {
        // 参数校验
        return this.accountMapper.insert(accountDO);
    }

    /**
     * 更新一个用户
     *
     * @param accountDO 用户实体
     * @return 影响的记录数
     */
    public int update(AccountDO accountDO) {
        // 参数校验
        return this.accountMapper.update(accountDO);
    }

    /**
     * 删除一个用户
     *
     * @param accountId 用户id
     * @return 影响的纪录数
     */
    public int delete(String accountId) {
        // 参数校验
        return this.accountMapper.delete(accountId);
    }

    /**
     * 用户分页查询
     *
     * @param start 起始
     * @param end   结束
     * @return 范围内的数据
     */
    public List<AccountDO> listRange(int start, int end) {
        return this.accountMapper.listRange(start, end);
    }
}
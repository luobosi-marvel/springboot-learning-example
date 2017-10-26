/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao;


import org.spring.springboot.dao.mapper.AccountBalanceMapper;
import org.spring.springboot.domain.AccountBalanceDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * AccountBalanceDAO
 *
 * @author 萝卜丝
 * @since 2017-10-11
 */
@Repository
public class AccountBalanceDAO {

    @Resource
    private AccountBalanceMapper accountBalanceMapper;

    /**
     * 根据主键获取账户余额信息
     *
     * @return 查找之后的余额信息
     */
    public AccountBalanceDO get() {
        return this.accountBalanceMapper.findAll();
    }

    /**
     * 修改账户余额信息
     *
     * @param accountBalanceDO 账户余额 DO 类
     * @return 影响的结果数
     */
    public int update(AccountBalanceDO accountBalanceDO) {
        return this.accountBalanceMapper.update(accountBalanceDO);
    }


    /**
     * 插入 AccountBalance
     *
     * @param accountBalanceDO 账户余额 DO
     * @author zhutou
     */
    public int insert(AccountBalanceDO accountBalanceDO) {
        return accountBalanceMapper.insert(accountBalanceDO);
    }


}

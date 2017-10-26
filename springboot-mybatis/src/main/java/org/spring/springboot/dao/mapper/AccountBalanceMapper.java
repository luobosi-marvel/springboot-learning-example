/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.dao.mapper;

import org.spring.springboot.domain.AccountBalanceDO;
import org.springframework.stereotype.Component;

/**
 * AccountBalanceMapper
 *
 * @author zhutou
 * @since 2017-10-09
 */
@Component
public interface AccountBalanceMapper {


    /**
     * 根据主键获取账户余额信息
     *
     * @return 查找之后的余额信息
     */
    AccountBalanceDO findAll();


    /**
     * 插入 AccountBalance
     *
     * @param accountBalanceDO 账户余额 DO 类
     * @return 影响的结果数
     */
    int insert(AccountBalanceDO accountBalanceDO);

    /**
     * 修改账户余额信息
     *
     * @param accountBalanceDO 账户余额 DO 类
     * @return 影响的结果数
     */
    int update(AccountBalanceDO accountBalanceDO);



}

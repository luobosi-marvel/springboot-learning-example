/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.domain;


import lombok.Data;
import org.spring.springboot.domain.base.Base;

/**
 * AccountBalanceDO
 * 账户余额表
 *
 * @author zhutou
 * @since 2017-10-09
 */
@Data
public class AccountBalanceDO extends Base {
    /**
     * ID
     */
    private String accountBalanceId;

    /**
     * 账户id
     */
    private String accountId;

    /**
     * 余额
     */
    private Long balance;

    /**
     * 已冻结资金
     */
    private Long freeze;

    /**
     * 默认的构造方法
     */
    public AccountBalanceDO(){}


}

/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Amount
 *
 * @author 萝卜丝
 * @since 2017-11-10
 */
@Data
@AllArgsConstructor
public class Amount {
    /** 提现金额 */
    private Long amount;
}
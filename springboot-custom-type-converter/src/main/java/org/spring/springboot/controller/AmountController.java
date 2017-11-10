/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.controller;

import org.spring.springboot.bean.Amount;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AmountController
 *
 * @author 萝卜丝
 * @since 2017-11-10
 */
@RestController
public class AmountController {
    @RequestMapping(value = "get/amount/{amount}")
    public Amount returnAmount(@PathVariable(value = "amount") Amount amount) {
        return amount;
    }
}
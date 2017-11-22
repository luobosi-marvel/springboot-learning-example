/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.controller;

import com.spring.springboot.smp.service.AccountService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * AccountController
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Controller
public class AccountController {

    @Resource
    private AccountService accountService;
}
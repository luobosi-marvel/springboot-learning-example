/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.controller;

import com.spring.springboot.bean.AccountBean;
import com.spring.springboot.controller.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * AccountController
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@RestController
public class AccountController extends BaseController{

    @GetMapping(value = "/get/account/list")
    public AccountBean queryAccount(HttpServletRequest request) {
        return null;

    }
}
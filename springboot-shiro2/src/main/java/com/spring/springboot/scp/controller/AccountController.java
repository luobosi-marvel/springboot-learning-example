/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.controller;

import com.spring.springboot.scp.bean.AccountInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccountController
 *
 * @author 萝卜丝
 * @since 2017-09-18
 */
@RestController
public class AccountController {

    @GetMapping(value = "get/account")
    public AccountInfo getAccount() {
        Subject subject = SecurityUtils.getSubject();
        AccountInfo user = (AccountInfo) subject.getSession().getAttribute("user");
        return user;
    }
}
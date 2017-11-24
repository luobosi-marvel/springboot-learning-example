/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.controller;

import com.spring.springboot.bean.AccountBean;
import com.spring.springboot.controller.base.BaseController;
import com.spring.springboot.page.Page;
import com.spring.springboot.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * AccountController
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@RestController
public class AccountController extends BaseController{

    @Resource
    private AccountService accountService;

    @GetMapping(value = "/get/account/list")
    public AccountBean queryAccount(HttpServletRequest request) {

        // 获取总纪录数
        Long totalCount = this.accountService.getPageCounts();
        // 计算页面
        Page page = executePage(request, totalCount);

        return null;

    }
}
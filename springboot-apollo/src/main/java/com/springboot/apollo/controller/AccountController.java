/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.springboot.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccountController
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-23
 */
@RestController
public class AccountController {

    @Value("${material.remoteurl}")
    private String materialRemoteUrl;

    @GetMapping("/get/url")
    public String getUrl() {
        return materialRemoteUrl;
    }
}
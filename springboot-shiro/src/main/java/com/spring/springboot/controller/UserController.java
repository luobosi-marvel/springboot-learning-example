/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * UserController
 *
 * @author 萝卜丝
 * @since 2017-09-12
 */
@Controller
public class UserController {

    @GetMapping("/toIndex")
    public String toIndex() {
        System.out.println(1);
        return "index";
    }
}
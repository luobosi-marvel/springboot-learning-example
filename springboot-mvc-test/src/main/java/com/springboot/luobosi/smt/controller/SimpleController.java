/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.springboot.luobosi.smt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SimpleController
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-01
 */
@RestController
public class SimpleController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home(String name) {
        return name + "'s home";
    }
}
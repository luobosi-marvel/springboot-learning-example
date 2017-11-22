/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * LoginController
 *
 * @author 萝卜丝
 * @since 2017-10-21
 */
@Controller
public class LoginController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @RequestParam(value = "username") String mobile,
                        @RequestParam(value = "password") String password) throws Exception {

        System.out.println("LoginController.login(post)");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        UsernamePasswordToken token = new UsernamePasswordToken(mobile, password);
        Subject subject = SecurityUtils.getSubject();


        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 用户名或密码不正确");
                msg = "UnknownAccountException -- >用户名或密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else if (DisabledAccountException.class.getName().equals(exception)) {
                System.out.println("DisabledAccountException -- > 该账号已经被暂停使用");
                msg = "DisabledAccountException -- > 该账号已经被暂停使用";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        } else {
            return "/index";
        }
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }
}
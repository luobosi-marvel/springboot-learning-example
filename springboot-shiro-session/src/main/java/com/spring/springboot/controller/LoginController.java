/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    public String login(HttpServletRequest request, Map<String, Object> map)throws Exception {

        System.out.println("LoginController.login(post)");
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";

        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 用户名或密码不正确");
                msg = "UnknownAccountException -- >用户名或密码不正确";
            }  else if (DisabledAccountException.class.getName().equals(exception)) {
                System.out.println("DisabledAccountException -- > 该账号已经被暂停使用!");
                msg = "DisabledAccountException -- > 该账号已经被暂停使用";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        } else {
            Session session = SecurityUtils.getSubject().getSession();


            return "index";
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "login";
    }


    /**
     * 退出登录
     * @return 返回登录视图
     */
    @GetMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "login";
    }

}
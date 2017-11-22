/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.controller;

import com.spring.springboot.scp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author 萝卜丝
 * @since 2017-10-11
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/marvel")
    public String insert() {
        try {
            /*userService.insert(new User(1236536L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(1236537L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(1236538L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(1236539L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(1236532L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(12365322L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(1236531L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(1236531L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(123653221L, "marvel", UUID.randomUUID().toString(), 22));
            userService.insert(new User(12365333L, "marvel", UUID.randomUUID().toString(), 22));*/
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
        return "成功";
    }
}
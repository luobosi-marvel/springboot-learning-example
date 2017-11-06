/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.controller;

import org.spring.springboot.bean.DateTimestamp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author 萝卜丝
 * @since 2017-11-06
 */
@RestController
public class IndexController {

    @GetMapping(value = "/v1/get/start/time/{start_time}")
    public DateTimestamp getStartTime(@PathVariable(value = "start_time") DateTimestamp startTime) {
        return startTime;
    }
}
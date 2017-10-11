/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.controller;

import org.spring.springboot.domain.ScanCode;
import org.spring.springboot.service.ScanCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * ScanCodeController
 *
 * @author 萝卜丝
 * @since 2017-10-10
 */
@RestController
public class ScanCodeController {

    @Resource
    private ScanCodeService scanCodeService;

    @GetMapping("/marvel")
    public String insert() {
        ScanCode scanCode = new ScanCode();
        scanCode.setScanCodeId(UUID.randomUUID().toString());
        scanCode.setCustomerRegisterId(UUID.randomUUID().toString());
        scanCodeService.insert(scanCode);
        return "success";
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * ScanCode（扫码表）
 *
 * @author 萝卜丝
 * @since 2017-09-19
 */

@Data
public class ScanCode implements Serializable{
    private static final long serialVersionUID = 5751635931766068513L;
    /**
     * 扫码ID（主键）
     */
    private String scanCodeId;
    /**
     * 顾客注册ID
     */
    private String customerRegisterId;

}
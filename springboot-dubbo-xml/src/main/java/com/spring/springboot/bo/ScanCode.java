/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.bo;


import com.spring.springboot.bo.base.Base;
import lombok.Data;

/**
 * ScanCode（扫码表）
 *
 * @author 萝卜丝
 * @since 2017-09-19
 */
@Data
public class ScanCode extends Base {

    /**
     * 扫码ID（主键）
     */
    private String scanCodeId;
    /**
     * 小二ID
     */
    private String customerRegisterId;
    /**
     * 销售码
     */
    private Long saleCode;
    /**
     * 扫码时间
     */
    private Long scanTime;
    /**
     * APP首次登录时间
     */
    private Long firstLoginTime;

}
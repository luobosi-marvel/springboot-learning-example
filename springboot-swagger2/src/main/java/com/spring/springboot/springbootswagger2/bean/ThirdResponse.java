/*
 * Copyright (C) 2009-2018 Hangzhou Iroly Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Date: 2019-02-24
 * Time: 15:20
 * Description: 第三方系统返回结果
 *
 * @author qiezi
 */
@Data
public class ThirdResponse implements Serializable {

    /**
     * 响应结果
     */
    private Integer code;
    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 对象
     */
    private String data;
}


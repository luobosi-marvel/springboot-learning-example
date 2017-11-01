/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.vo;

import lombok.Data;

/**
 * ResultRrlVO
 *
 * @author 萝卜丝
 * @since 2017-11-01
 */
@Data
public class ResultRrlVO {

    /** 信息码 */
    private String code;
    /** 响应中的数据 */
    private String data;
    /** 信息 */
    private String message;

}
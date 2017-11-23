/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.dto.base;

import lombok.Data;

import java.io.Serializable;

/**
 * Base
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-23
 */
@Data
public abstract class Base implements Serializable{
    private static final long serialVersionUID = 1680709716189522239L;
    /** 排序名字 */
    private String orderName;
    /** 升序 or 降序 */
    private String descAsc;
    /** 起始下标 */
    private Long startIndex;
    /** 结束下标 */
    private Long endIndex;
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.page;

import com.spring.springboot.util.NumberFormatUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * BaseController
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public class BaseController {

    /**
     * 子类在展现数据前,进行分页计算!
     *
     * @param request       request
     * @param totalCount    根据查询 SQL 获取的总条数
     * @return              计算之后的分页对象
     */
    protected Page executePage(HttpServletRequest request, Long totalCount) {

        Long pageNumber = NumberFormatUtil.procRequestLong(request, "currnet");
        return null;
    }
}
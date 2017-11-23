/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.controller.base;

import com.spring.springboot.constant.Constants;
import com.spring.springboot.page.Page;
import com.spring.springboot.page.PageState;
import com.spring.springboot.page.PageUtil;
import com.spring.springboot.util.NumberFormatUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * BaseController
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public abstract class BaseController {

    /**
     * 子类在展现数据前,进行分页计算!
     *
     * @param request       request
     * @param totalCount    根据查询 SQL 获取的总条数
     * @return              计算之后的分页对象
     */
    protected Page executePage(HttpServletRequest request, Long totalCount) {
        // 从 request 域中获取当前是第几页
        Long pageNumber = NumberFormatUtil.procRequestLong(request, Constants.PageConstants.CURRENT_PAGE);

        Page page = new Page();
        //设置当前页
        page.setCurrentPage(pageNumber);
        //设置总纪录数
        if (null == totalCount) {
            page.setTotalCount(0L);
        } else {
            page.setTotalCount(totalCount);
        }

        // 页面状态,这个状态是分页自带的,与业务无关
        String pageAction = request.getParameter(Constants.PageConstants.PAGE_ACTION);
        String value = request.getParameter(Constants.PageConstants.PAGE_KEY);

        // 获取下标判断分页状态
        int pageState = PageState.getOrdinal(pageAction);

        /**
         * pageState < 1 只有二种状态 1 当首次调用时,分页状态类中没有值为 NULL 返回 -1 2 当页面设置每页显示多少条:
         * pageState = 0,当每页显示多少条时,分页类要重新计算
         */

        if (pageState < 1) {
            page = PageUtil.inintPage(totalCount, pageState, value, page);
        } else {
            page = PageUtil.calculatePage(pageState, value, page);
        }
        return page;
    }
}
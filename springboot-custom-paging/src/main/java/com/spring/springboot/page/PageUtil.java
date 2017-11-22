/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.page;

/**
 * PageUtil（分页工具类）
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public class PageUtil {
    public static final String ASC = "asc";
    public static final String DESC = "desc";
    public static final String PAGE_DESC = "↓";
    public static final String PAGE_ASC = "↑";
    public static final String PAGE_NULL = "&nbsp;&nbsp;";
    public static final String SESSION_PAGE_KEY = "page";

    /**
     * 初始化分页类
     *
     * @param totalCount    总行数
     * @param index         分页状态
     * @param value         只有在设置每页显示多少条时,值不会NULL,其它为NULL
     * @param sessionPage   session 中的分页类
     * @return 返回初始化之后的分页类
     */
    public static Page inintPage(Long totalCount, Integer index, String value, Page sessionPage) {
        Page page = null;
        if (index < 0) {
            page = new Page(totalCount);
        } else {
            // 每页显示多少条
            Long everPage = value == null ? 10L : Long.parseLong(value);
            // 获取 Session 中的分页类， 方便保存页面分页状态
            page = sessionPage;
            page.setEveryPage(everPage);
            page.setTotalCount(totalCount);
        }
        return page;
    }

    /**
     * 当页面点击：首页,前一页,后一页,末页,排序,到第多少页时进行分页操作
     *
     * @param index         分页状态
     * @param value         排序字段名或者到第多少页
     * @param sessionPage   session 中保存的分页类
     * @return
     */
    public static Page calculatePage(int index, String value, Page sessionPage) {
        Page page = sessionPage;
        // 调用方法进行分页计算
        page.pageState(index, value);
        return page;
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.smp.page;

import lombok.Data;

import java.util.List;

/**
 * PageBean(分页 bean)
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Data
public class PageBean<T> {
    /** 当前页 */
    private Integer currentPage = 1;
    /** 每页显示的总条数 */
    private Integer pageSize = 10;
    /** 总条数 */
    private Long totalNum;
    /** 是否有下一页 */
    private Integer isNext;
    /** 总页数 */
    private Integer totalPage;
    /** 开始索引 */
    private Integer startIndex;
    /** 分页结果 */
    private List<T> items;

    /**
     * 默认构造方法
     */
    public PageBean() {}

    /**
     * 带有三个参数的构造法方法
     *
     * @param currentPage 当前页
     * @param pageSize    每页显示的总条数
     * @param totalNum    总条数
     */
    public PageBean(Integer currentPage, Integer pageSize, Long totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Page
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@ToString
public class Page implements Serializable {
    private static final long serialVersionUID = 4729574245011115009L;
    /** 是否有前一页 */
    @Setter @Getter
    private Boolean hasPrePage;
    /** 是否有后一页 */
    @Setter
    private Boolean hasNextPage;
    /** 每页显示多少条:默认10条 */
    @Setter
    private Long everyPage = 10L;
    /** 总页数 */
    private Long totalPage;
    /** 当前第多少页:默认第1页 */
    private Long currentPage;
    /** 开始下标 */
    @Setter
    private Long beginIndex;
    /** 结束下标 */
    @Setter
    private Long endIndex;
    /** 总共多少条纪录 */
    @Getter
    private Long totalCount;
    /** 排序列名 */
    @Getter
    private String sortName;
    /** 排序状态 */
    @Setter @Getter
    private String sortState;
    /** 排序信息 */
    @Setter @Getter
    private String sortInfo;
    /** 是否排序 */
    @Setter @Getter
    private Boolean sort = false;

    /**
     * 默认的构造方法
     */
    public Page(){}

    /**
     * 常用，用于计算分页
     *
     * @param totalRecords 总记录数
     */
    public Page(Long totalRecords) {
        this.totalCount = totalRecords;
    }

    /**
     * 用户判断页面的状态
     *
     * @param state   状态码
     * @param value   到第多少页或者设置每页显示多少条或者为排序列名
     */
    public void pageState(int state, String value) {
        sort = false;
        switch (state) {
            case 0 : setEveryPage(Long.parseLong(value));break;
            case 1 : first();break;
            case 2 : previous();break;
            case 3 : next();break;
            case 4 : last();break;
            case 5 : sort = true;sort(value);break;
            case 6 :
                setCurrentPage(Long.parseLong(value));break;
        }
    }


    public Long getEndIndex() {
        this.endIndex = (currentPage) * everyPage;
        return endIndex;
    }

    /**
     * 判断是否有下一页
     *
     * @return true/false
     */
    public Boolean getHasNextPage() {
        return (this.currentPage.equals(this.totalPage)) && (totalPage != 0);
    }

    /**
     * 设置总页数的值
     *
     * @param totalPage 总页数
     */
    public void setTotalPage(Long totalPage) {
        if(this.currentPage > totalPage){
            this.currentPage = totalPage;
        }
        this.totalPage = totalPage;
    }

    /**
     * 设置总共有多少纪录
     *
     * @param totalCount 总记录数
     */
    public void setTotalCount(Long totalCount) {
        setTotalPage(getTotalPage(totalCount));
        this.totalCount = totalCount;
    }

    /**
     * 计算总页数
     * */
    private Long getTotalPage(Long totalRecords) {
        Long totalPage = 0L;
        everyPage = everyPage == null ? 10L : everyPage;
        if (totalRecords % everyPage == 0) {
            totalPage = totalRecords / everyPage;
        } else {
            totalPage = totalRecords / everyPage + 1;
        }
        return totalPage;
    }

    /**
     * 获取起始页
     *
     * @return 返回起始页
     */
    public Long getBeginIndex() {
        this.beginIndex = (currentPage - 1) * everyPage;
        return this.beginIndex;
    }

    /**
     * 获取当前页
     *
     * @return 当前页
     */
    public Long getCurrentPage() {
        this.currentPage = currentPage == 0 ? 1 : currentPage;
        return this.currentPage;
    }

    /**
     * 设置当前页
     *
     * @param currentPage 当前页
     */
    public void setCurrentPage(Long currentPage) {
        if(0 == currentPage){
            currentPage = 1L;
        }
        this.currentPage = currentPage;
    }

    public Long getEveryPage() {
        this.everyPage = everyPage == 0 ? 30 : everyPage;
        return this.everyPage;
    }

    /**
     * 首页
     */
    private void first() {
        this.currentPage = 1L;
    }

    /**
     * 前一页
     */
    private void previous() {
        this.currentPage--;
    }

    /**
     * 后一页
     */
    private void next() {
        this.currentPage ++;
    }

    /**
     * 最后一页
     */
    private void last() {
        this.currentPage = totalPage;
    }

    private void sort(String sortName) {

    }

    /**
     * 设置排序状态
     *
     * @param newPageSortName 新的页面排序名称
     */
    private void setPageSortState(String newPageSortName) {
        // 判断之前的排序字段是否为空
        if (StringUtils.isEmpty(sortName)) {
            // 默认排序为升序
            this.sortState = PageUtil.ASC;
            this.sortInfo = PageUtil.PAGE_ASC;
        } else {
            if (StringUtils.equalsIgnoreCase(newPageSortName, sortName)) {
                // 判断 sortState 排序状态值
                if (StringUtils.equalsIgnoreCase(sortState, PageUtil.ASC)) {
                    this.sortState = PageUtil.DESC;
                    this.sortInfo = PageUtil.PAGE_DESC;
                } else {
                    this.sortState = PageUtil.ASC;
                    this.sortInfo = PageUtil.PAGE_ASC;
                }
            } else {
                // 默认
                this.sortState = PageUtil.ASC;
                this.sortInfo = PageUtil.PAGE_ASC;
            }
        }
        sortName = newPageSortName.toLowerCase();
    }

}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.constant;

/**
 * Constants (用来存放一些常量)
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
public class Constants {

    /**
     * 和分页相关的一些常量
     */
    public interface PageConstants {
        /** 当前是第几页，前端传入的参数 */
        String CURRENT_PAGE = "current";
        /** 页面状态，前端传入的参数 */
        String PAGE_ACTION = "pageAction";
        /** 将要获取第几页的数据，前端传入的参数 */
        String PAGE_KEY = "pageKey";
    }

}
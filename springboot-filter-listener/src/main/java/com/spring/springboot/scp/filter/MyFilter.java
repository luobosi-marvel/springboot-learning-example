/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * MyFilter
 *
 * @author 萝卜丝
 * @since 2017-09-14
 *
 * 使用注解标注过滤器，@WebFilter 将一个实现了 javax.servlet.Filter 接口的类定义为过滤器
 * 属性 filterName 声明过滤器的名称，可选
 * 属性 urlPatterns 指定要过滤的 URL 模式，也可使用属性 value 来声明.(指定要过滤的 URL 模式是必选模式)
 *
 * 注意：使用 @WebFilter 一定要在启动类上加 @ServletComponentScan 这个注解
 */
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器执行");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
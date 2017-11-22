/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.filter;

/**
 * TokenFilter
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-13
 */
public class TokenFilter {

 /*   @Resource
    private RedisTemplate redisTemplate;

    @Override
    public
    void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("=========once per request filter");
        chain.doFilter(request, response);
    }

    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = request.getParameter("token");
        System.out.println(token);

        // 说明没有不需要验证token
        if (token == null) {
            filterChain.doFilter(request, response);
        }

        if ("".equals(token)) {
            // 说明token 为空，需要验证但是没有传入 token ，跳转到登录页面
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "no user in session");
            return;
        }

        // 把 token 当作key 值从 redis 里面获取
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        AccountInfo account = (AccountInfo) valueOperations.get(token);
        // 如果获取到了则放行
        if (account == null) {
            // 说明token 为空，需要验证但是没有传入 token ，跳转到登录页面
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "no user in session");
            return;
        }
        // 如果获取到的内容为空，则跳转到登录页面

        System.out.println("过滤器执行");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }*/
}
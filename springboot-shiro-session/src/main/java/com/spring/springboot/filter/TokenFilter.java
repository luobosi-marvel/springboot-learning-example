/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.filter;

import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TokenFilter
 *
 * @author 萝卜丝
 * @since 2017-10-30
 */
public class TokenFilter extends UserFilter{
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        String loginUrl = "/login";
        String callback = request.getParameter("callback");
        String token = request.getParameter("token");
        Map<String, Object> map = new HashMap<String, Object>();
        if (callback != null){
            map.put("callback", callback);

        }
        if (token !=null){
            map.put("token",token);
        }
//        WebUtils.issueRedirect(request, response, loginUrl, map);
        HttpServletRequest hRequest = (HttpServletRequest)request;
        try {
            hRequest.getRequestDispatcher(loginUrl).forward(request,response);
        } catch (Exception e) {
            System.out.println("转发出错！");
        }

    }
}
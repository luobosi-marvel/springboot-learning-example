/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.filter;

/**
 * UserAutowiredFilter
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-13
 */
public class UserAutowiredFilter{
 /*   @Override
    public void setLoginUrl(String loginUrl) {
        super.setLoginUrl(loginUrl);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return super.onAccessDenied(request, response);
    }

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        String loginUrl = getLoginUrl();
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
*/
}
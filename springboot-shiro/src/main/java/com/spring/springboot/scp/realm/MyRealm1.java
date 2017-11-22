/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.realm;


import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * MyRealm1
 *
 * @author 萝卜丝
 * @since 2017-09-14
 */
public class MyRealm1 implements Realm {


    @Override
    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        // 仅支持 UsernamePasswordToken 类型的 Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();// 得到用户名
        String password = new String((char[]) token.getCredentials());// 得到密码

        if (!"marvel".equals(principal)) {
            throw new UnknownAccountException();// 如果用户名错误，则抛出 错误账号异常
        }

        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException(); // 如果密码错误，则抛出 错误凭证异常
        }

        // 如果身份认证验证成功，返回一个 AuthenticationInfo 实现
        return new SimpleAuthenticationInfo(principal, password, getName());
    }
}
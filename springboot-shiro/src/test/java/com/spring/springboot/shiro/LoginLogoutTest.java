/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * LoginLogoutTest
 * 使用 Shiro 进行用户登录注册
 * @author 萝卜丝
 * @since 2017-09-14
 */
public class LoginLogoutTest {

    /**
     * 下面的代码可总结出身份验证的步骤：
     * 1. 收集用户身份/凭证，即如用户名/密码
     * 2. 调用 Subject.login 进行登录，如果失败将得到相应的 AuthenticationException 异常，根据异常提示用户错误信息；
     * 否则登录成功；
     * 3. 最后调用 Subject.logout 进行退出操作。
     */
    @Test
    public void testLoginLogout() {
    // 1. 获取 SecurityManager 工厂，此处使用 Ini 配置文件初始化 SecurityManager
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 2. 得到 SecurityManager 实例，并绑定到 SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        // 3. 得到 Subject 及创建用户名/密码身份验证 Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1235");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5. 身份验证失败
            System.out.println("身份验证失败");// 最好提示用户名/密码错误，而不是分开提示
        }
        Assert.assertEquals(true, subject.isAuthenticated()); // 断言用户已经登录

        // 6. 退出
        subject.logout();
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ShiroConfiguration
 * Shiro 配置
 *
 * Apache Shiro 核心通过 Filter 来实现，就好像 SpringMvc 通过 DispachServlet 来控制一样。
 * 既然是使用 Filter 一般也就能猜到，是通过 URL 规则来进行过滤和权限校验，所以我们需要
 * 定义一系列关于 URL 的规则和访问权限。
 * @author 萝卜丝
 * @since 2017-09-12
 */
@Configuration
public class ShiroConfiguration {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     *
     * 注意：单独一个 ShiroFilterFactoryBean 配置是会报错的，因为在
     * 初始化 ShiroFilterFactoryBean 的时候需要注入：SecurityManager
     *
     *      Filter Chain 定义说明
     *      1. 一个 URL 可以配置多个 Filter， 使用都好分隔
     *      2. 当设置多个过滤器时，全部验证通过，才视为通过
     *      3. 部分过滤器可指定参数，如 perms，roles
     * @return 返回 ShiroFilter 过滤器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器
        Map<String, String> filterchainDefinitionMap = new LinkedHashMap<>();
        // 配置推出过滤器，其中的具体的退出代码 Shiro 已经替我们实现了
        filterchainDefinitionMap.put("/logout", "logout");
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /** 放在最下边 --> 这是一个坑
        // <!-- authc：所有 url 都必须认证通过才可以访问；anon：所有url 都可以匿名访问-->
        filterchainDefinitionMap.put("/**", "authc");
        // 如果不设置默认会自动寻找 Web 工程根目录下的 "/login.jsp" 页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/430");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterchainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        // 使用这个对象报错：The security manager does not implement the WebSecurityManager interface.
        // DefaultSecurityManager securityManager = new DefaultSecurityManager();
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    /**
     * 身份认证realm;
     * (这个需要自己写，账号密码校验；权限等)
     * @return 返回身份认证 realm
     */
    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        // 添加凭证匹配器
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 凭证匹配器
     * 由于我们的密码校验交给 Shiro 的 SimpleAuthenticationInfo 进行处理了，
     * 所以我们需要修改下 doGetAuthenticationInfo 中的代码
     * @return 返回凭证匹配器
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法：这里使用 MD5 算法
        credentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于 md5(md5(""))
        credentialsMatcher.setHashIterations(2);
        return credentialsMatcher;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager 权限管理器
     * @return authorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.realm;

import com.spring.springboot.bean.Account;
import com.spring.springboot.dao.AccountDAO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * MyShiroRealm
 *
 * @author 萝卜丝
 * @since 2017-10-09
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private AccountDAO accountDAO;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     * @param token 身份认证信息
     * @return 认证之后的信息
     * @throws AuthenticationException 验证不通过则抛出异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String name = (String)token.getPrincipal();

        Account account = accountDAO.findByName(name);

        if(account == null){
            throw new UnknownAccountException("用户名或密码不正确!");
        }

        if (account.getAccountState() == 1) {
            throw new DisabledAccountException("该账户已经被禁用!");
        }


        /*
         * 获取权限信息:这里没有进行实现，
         * 请自行根据UserInfo,Role,Permission进行实现；
         * 获取之后可以在前端for循环显示所有链接;
         */
        //userInfo.setPermissions(userService.findPermissions(user));


        //账号判断;

        //加密方式;
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(
                account, //用户名
                account.getPassword(), //密码
                null,//salt
                getName()  //realm name
        );
    }



    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     * 是权限控制，当访问到页面的时候，使用了相应的注解或者shiro标签才会执行此方法否则不会执行，
     * 所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     *
     * @param principals 身份及凭据
     * @return 权限验证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("权限配置 --> MyShiroRealm.doGetAuthorizationInfo()");

        // SimpleAuthorizationInfo: 进行角色的添加和权限的添加。
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }



}
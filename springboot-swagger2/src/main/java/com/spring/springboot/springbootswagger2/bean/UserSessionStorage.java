/*
 * Copyright (C) 2009-2018 Hangzhou Iroly Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Date: 2019-02-13
 * Time: 16:02
 * Description: 用户信息缓存块
 *
 * @author qiezi
 */
@Data
public class UserSessionStorage implements Serializable {

    private static final long serialVersionUID = 8171320097894079335L;

    /**
     * 客户端应用唯一标识
     */
    private String appId;

    /**
     * 客户端应用唯一openId
     */
    private String openId;

    /**
     * 客户端应用唯一unionId
     */
    private String unionId;

    /**
     * 服务端唯一用户ID
     */
    private Integer userId;

    /**
     * 小程序用户令牌
     */
    private String sessionKey;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatarUrl;
}


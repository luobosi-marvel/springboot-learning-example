/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * AccountVO
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Data
@ToString
public class AccountVO implements Serializable{
    private static final long serialVersionUID = 9027994997311418116L;
    /** 用户id */
    private String accountId;
    /** 手机号 */
    private String mobile;
    /** 用户名 */
    private String username;
    /** 真实姓名 */
    private String realName;
    /** 邮箱 */
    private String mailbox;
    /** 用户状态 */
    private String accountStatus;
}
/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.domain;

import com.spring.springboot.scp.domain.base.Base;
import lombok.Data;
import lombok.ToString;

/**
 * AccountDO
 *
 * @author luobosi@2dfire.com
 * @since 2017-11-22
 */
@Data
@ToString
public class AccountDO extends Base{
    /** 用户id */
    private String accountId;
    /** 手机号 */
    private String mobile;
    /** 用户名 */
    private String username;
    /** 用户密码 */
    private String password;
    /** 真实姓名 */
    private String realName;
    /** 邮箱 */
    private String mailbox;
    /** 用户状态 */
    private String accountStatus;
}
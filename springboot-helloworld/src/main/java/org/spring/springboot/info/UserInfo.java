/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package org.spring.springboot.info;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * UserInfo
 *
 * @author luobosi@2dfire.com
 * @since 2017-12-14
 */
public class UserInfo implements Serializable{
    @JsonProperty("user_name")
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
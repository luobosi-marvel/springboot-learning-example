/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.scp.springbootswagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * User
 *
 * @author 萝卜丝
 * @since 2017-09-26
 */
@ApiModel(value = "用户实体类")
@Data
public class User {
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private int age;
}
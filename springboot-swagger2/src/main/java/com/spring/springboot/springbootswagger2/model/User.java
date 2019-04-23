/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * User
 *
 * @author 萝卜丝
 * @since 2017-09-26
 */
@ApiModel(value = "用户实体类", description="用户对象user")
@Data
public class User {
    @ApiModelProperty(value = "用户id", name = "id")
    private Long id;
    @ApiModelProperty(value = "姓名", name = "username")
    private String name;
    @ApiModelProperty(value = "年龄", name = "age")
    private int age;
}
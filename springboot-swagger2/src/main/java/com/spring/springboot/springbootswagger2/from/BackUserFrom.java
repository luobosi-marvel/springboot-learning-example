/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * BackUserFrom
 *
 * @author marvel
 * @since 2019-04-14
 */
@Data
@ApiModel(value = "backUserFrom", description="员工实体, 可用于新建和修改")
public class BackUserFrom implements Serializable {
    @ApiModelProperty(name = "该实体id，只有当修改的时候才需要传入该id", value = "12345", required = true)
    private Integer id;
    @ApiModelProperty(name = "门店id", value = "12345", required = true)
    private Integer storeId;
    @ApiModelProperty(name = "员工名称", value = "登风", required = true)
    private String username;
    @ApiModelProperty(name = "手机号", value = "12343292329", required = true)
    private String phone;
    @ApiModelProperty(name = "默认密码", value = "123456", required = true)
    private String password;
    @ApiModelProperty(name = "员工角色", value = "销售角色的id", required = true)
    private Integer roleId;
    @ApiModelProperty(name = "对外职称", value = "法务", required = true)
    private String externalTitle;
    @ApiModelProperty(name = "qq号", value = "242455233", required = true)
    private String qqNumber;
    @ApiModelProperty(name = "员工邮箱", value = "2452589923@qq.com", required = true)
    private String email;
}

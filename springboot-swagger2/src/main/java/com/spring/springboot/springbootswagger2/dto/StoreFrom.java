/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * BackUserDTO
 *
 * @author zhutou
 * @since 2019-02-15
 */
@Data
@ApiModel(value = "storeFrom", description="店铺实体")
public class StoreFrom implements Serializable {

    private static final long serialVersionUID = 1648931810096832061L;

    /**自增主键*/
    @ApiModelProperty(name = "id", value = "1", hidden = true)
    private Integer id;
    /**
     * back_user_id
     */
    @ApiModelProperty(name = "backUserId", value = "backUserId", required = true)
    private Integer backUserId;

    @ApiModelProperty(name = "oldStoreId", value = "oldStoreId", required = true)
    private String oldStoreId = "";

    /**
     * 店铺名称
     */
    @ApiModelProperty(name = "店铺名称", value = "店铺名称", required = true)
    private String name;

    /**
     * 详细地址
     */
    @ApiModelProperty(name = "详细地址", value = "详细地址", required = true)
    private String address = "";

    /**店长姓名*/
    @ApiModelProperty(name = "店长姓名", value = "店长姓名", required = true)
    private String shopkeeperName;

    /**店长手机号*/
    @ApiModelProperty(name = "店长手机号", value = "店长手机号", required = true)
    private String shopkeeperPhone;

    /**门店电话*/
    @ApiModelProperty(name = "门店电话", value = "门店电话", required = true)
    private String shopPhone;

	/**
	 * 扩展属性
	 */
    @ApiModelProperty(name = "扩展属性", value = "扩展属性", required = true)
	private String extendField = "";

}

/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * GroupListVO
 *
 * @author marvel
 * @since 2019-04-06
 */
@ApiModel(value = "组员列表实体类", description="组员列表")
@Data
public class GroupListVO implements Serializable {

    /**
     * 组id
     */
    @ApiModelProperty(value = "组id", name = "组id")
    private Integer id;

    /**
     * 门店id
     */
    @ApiModelProperty(value = "门店id", name = "门店id")
    private Integer storeId;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称", name = "门店名称")
    private String storeName;

    /**
     * 组名
     */
    @ApiModelProperty(value = "小组名称", name = "小组名称")
    private String groupName;

    /**
     * 组长id
     */
    @ApiModelProperty(value = "组长id", name = "组长id")
    private String teamLeaderId;

    /**
     * 组长姓名
     */
    @ApiModelProperty(value = "组长姓名", name = "组长姓名")
    private String teamLeaderName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "手机号")
    private String phone;

    /**
     * 组员信息
     */
    @ApiModelProperty(value = "组员信息", name = "组员信息列表")
    private List<GroupMember> groupMembers;

    @Data
    public static class GroupMember implements Serializable{
        /**
         * 员工id
         */
        @ApiModelProperty(value = "员工id", name = "员工姓名")
        private Integer id;

        /**
         * 用户名
         */
        @ApiModelProperty(value = "用户名称", name = "用户名称")
        private String username;
    }
}

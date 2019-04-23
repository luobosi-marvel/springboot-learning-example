/*
 * Copyright (C) 2009-2018 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.springbootswagger2.controller;

import com.spring.springboot.springbootswagger2.from.CustomerGroupFrom;
import com.spring.springboot.springbootswagger2.util.JsonResult;
import com.spring.springboot.springbootswagger2.vo.GroupListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * GroupingController
 * 员工分组管理
 * 创建小组表（新增表）
 * 获取小组列表接口
 * 创建小组接口
 * 获取门店员工接口（排除已经设置过小组的员工）
 * 删除小组接口
 * 取消组长接口
 * 设置组长接口
 *
 * @author marvel
 * @since 2019-04-06
 */
@Api(value = "员工分组管理",description = "关于员工分组的相关接口")
@RestController
@Validated
@RequestMapping("/api/group")
@SuppressWarnings("unchecked")
public class GroupController {


    /**
     * 创建小组表
     *
     * @param customerGroupDTO dto
     * @return boolean
     */
    @ApiOperation(value = "创建一个小组信息", notes = "创建一个小组信息")
    @PostMapping(value = "/create")
    public JsonResult<Boolean> create(@RequestBody @Validated CustomerGroupFrom customerGroupDTO) {
        return JsonResult.builder().data(true).build();
    }

    /**
     * 更新一个分组信息
     *
     * @param customerGroupDTO dto
     * @return boolean
     */
    @PostMapping(value = "/update")
    @ApiOperation(value = "更新一个小组信息", notes = "更新一个小组信息")
    public JsonResult<Boolean> update(@RequestBody @Validated CustomerGroupFrom customerGroupDTO) {
        return JsonResult.builder().data(true).build();
    }


    /**
     * 根据门店id 获取未分组的员工信息
     *
     * @param storeId 门店id
     * @return 未分组员工信息列表
     */
    @GetMapping(value = "/unclassified_back_user")
    @ApiOperation(value = "根据门店id 获取未分组的员工信息", notes = "根据门店id 获取未分组的员工信息")
    @ApiImplicitParam(name = "store_id", value = "门店 id", required = true, dataType = "Integer")
    public JsonResult<List<GroupListVO.GroupMember>> unclassifiedCustomer(@RequestParam("store_id") Integer storeId) {

        return JsonResult.<List<GroupListVO.GroupMember>>builder().data(Collections.singletonList(new GroupListVO.GroupMember())).build();
    }

    /**
     * todo
     * 根据 组 id 删除一个分组信息
     * 1.注意删除分组的时候一定要解散整个小组
     *
     * @param groupId 分组id
     * @return boolean
     */
    @GetMapping(value = "/delete")
    @ApiOperation(value = "根据 组 id 删除一个分组信息", notes = "根据 组 id 删除一个分组信息")
    @ApiImplicitParam(name = "group_id", value = "小组 id", required = true, dataType = "Integer")
    public JsonResult<Boolean> delete(@RequestParam("group_id") Integer groupId) {


        return JsonResult.builder().data(true).build();
    }

    /**
     * todo
     * 根据门店id 获取所有组信息，包括组员信息
     *
     * @param storeId 门店id
     * @return boolean
     */
    @GetMapping(value = "/list")
    @ApiOperation(value = "根据门店id 获取所有组信息，包括组员信息", notes = "根据门店id 获取所有组信息，包括组员信息")
    @ApiImplicitParam(name = "store_id", value = "门店 id", required = true, dataType = "Integer")
    public JsonResult<List<GroupListVO>> list(@RequestParam("store_id") Integer storeId) {

        return JsonResult.<List<GroupListVO>>builder().data(Arrays.asList(new GroupListVO(), new GroupListVO())).build();
    }

}

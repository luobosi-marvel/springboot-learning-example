/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * SysRole
 * 系统角色实体类
 * @author 萝卜丝
 * @since 2017-09-12
 */
@Entity
@Data
@Table(name = "SysRole")
public class SysRole implements Serializable{

    /**
     * 主键 id
     */
    @Id @GeneratedValue
    private Long id;// 编号

    /**
     * 角色标识程序中判断使用，如 "admin"，这个是唯一的
     */
    private String role;

    /**
     * 角色描述，UI 界面显示使用
     */
    private String description;

    /**
     * 是否可用，如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    /**
     * 角色 --- 权限关系：多对多关系
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")},
        inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;

    /**
     * 用户 --- 角色关系定义
     * 一个角色对应多个用户
     */
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "roleId")},
        inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> userInfos;
}
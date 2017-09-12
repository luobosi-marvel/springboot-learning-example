/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package com.spring.springboot.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * SysPermission
 *
 * @author 萝卜丝
 * @since 2017-09-12
 */
@Entity
@Data
@Table(name = "SysPermission")
public class SysPermission implements Serializable {
    @Id
    @GeneratedValue
    private Long id;//主键.
    /** 名称 */
    private String name;
    // 给字段一个默认值
    /** 资源类型 */
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;
    /** 资源路径 */
    private String url;
    /**
     * 权限字符串,menu例子：role:*，
     *
     * button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;
    /** 父编号 */
    private Long parentId;
    /** 父编号列表 */
    private String parentIds;
    private Boolean available = Boolean.FALSE;

    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},
            inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;

}
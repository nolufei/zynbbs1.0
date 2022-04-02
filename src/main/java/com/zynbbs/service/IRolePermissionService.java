package com.zynbbs.service;

import java.util.List;

import com.zynbbs.model.RolePermission;

/**
 * Created by tomoya.
 * Copyright (c) 2018, All Rights Reserved.
 * https://yiiu.co
 */
public interface IRolePermissionService {
    // 根据角色id查询所有的角色权限关联记录
    List<RolePermission> selectByRoleId(Integer roleId);

    // 根据角色id删除关联关系
    void deleteByRoleId(Integer roleId);

    // 根据权限id删除关联关系
    void deleteByPermissionId(Integer permissionId);

    void insert(RolePermission rolePermission);
}

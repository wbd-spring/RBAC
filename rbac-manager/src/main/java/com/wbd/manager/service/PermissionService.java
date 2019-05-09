package com.wbd.manager.service;

import java.util.List;

import com.rbac.common.pojo.Permission;

public interface PermissionService {
	List<Permission> queryChildPermission(Integer id);

	void insertPermission(Permission permission);

	Permission queryPermissionById(Integer id);

	void updatePermission(Permission permission);

	void deletePermissionById(Integer id);

	List<Permission> queryAllPermission();

	List<Integer> queryPermissionByRoleId(Integer roleid);

	List<Permission> queryPermissionByUserId(Integer id);
}

package com.wbd.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbac.common.pojo.Permission;
import com.wbd.manager.dao.PermissionDao;
import com.wbd.manager.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	public List<Permission> queryChildPermission(Integer id) {
		return permissionDao.queryChildPermission(id);
	}

	public void insertPermission(Permission permission) {
		permissionDao.insertPermission(permission);
		
	}

	public Permission queryPermissionById(Integer id) {
		return permissionDao.queryPermissionById(id);
	}

	public void updatePermission(Permission permission) {
		permissionDao.updatePermission(permission);
		
	}

	public void deletePermissionById(Integer id) {
		permissionDao.deletePermissionById(id);
		
	}

	public List<Permission> queryAllPermission() {
		return permissionDao.queryAllPermission();
	}

	public List<Integer> queryPermissionByRoleId(Integer roleid) {
		return permissionDao.queryPermissionByRoleId(roleid);
	}

	public List<Permission> queryPermissionByUserId(Integer id) {
		return permissionDao.queryPermissionByUserId(id);
	}

}

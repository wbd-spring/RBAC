package com.wbd.manager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbac.common.pojo.Role;
import com.wbd.manager.dao.RoleDao;
import com.wbd.manager.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	public List<Role> pageQueryData(Map<String, Object> map) {
		return roleDao.pageQueryData(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		return roleDao.pageQueryCount(map);
	}

	public void deleteRoleById(Integer id) {
		
		roleDao.deleteRoleById(id);
	}

	public void insertRole(String name) {
		roleDao.insertRole(name);
		
	}

	public Role queryRoleById(Integer id) {
		return roleDao.queryRoleById(id);
	}

	public void updateRole(Role role) {
		roleDao.updateRole(role);
		
	}

}

package com.wbd.manager.service;

import java.util.List;
import java.util.Map;

import com.rbac.common.pojo.Role;

public interface RoleService {

	List<Role> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	void deleteRoleById(Integer id);

	void insertRole(String name);

	Role queryRoleById(Integer id);

	void updateRole(Role role);
}

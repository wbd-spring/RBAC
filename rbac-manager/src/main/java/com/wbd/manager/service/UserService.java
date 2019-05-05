package com.wbd.manager.service;

import java.util.List;
import java.util.Map;

import com.rbac.common.pojo.User;

public interface UserService {

	List<User> queryAllUser();
	
	User queryUserByConditon(User user);

	List<User> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	void insert(User user);

	User queryUserById(Integer id);

	void updateUser(User user);

	void removeUserById(Integer id);

	void deleteUsers(Map map);

	void insertUserRoles(Map<String, Object> param);

	void deletetUserRoles(Map<String, Object> param);

	List<Integer> queryUserRoleids(Integer id);

}

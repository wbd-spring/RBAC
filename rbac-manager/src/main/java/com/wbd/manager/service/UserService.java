package com.wbd.manager.service;

import java.util.List;

import com.rbac.common.pojo.User;

public interface UserService {

	List<User> queryAllUser();
	
	User queryUserByConditon(User user);
}

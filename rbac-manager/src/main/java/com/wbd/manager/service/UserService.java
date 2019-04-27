package com.wbd.manager.service;

import java.util.List;
import java.util.Map;

import com.rbac.common.pojo.User;

public interface UserService {

	List<User> queryAllUser();
	
	User queryUserByConditon(User user);

	List<User> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

}

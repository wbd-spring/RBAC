package com.wbd.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbac.common.pojo.User;
import com.wbd.manager.dao.UserDao;
import com.wbd.manager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<User> queryAllUser() {

		return userDao.queryAllUser();
	}

	public User queryUserByConditon(User user) {
		
		return userDao.queryUserByCondition(user);
	}

}

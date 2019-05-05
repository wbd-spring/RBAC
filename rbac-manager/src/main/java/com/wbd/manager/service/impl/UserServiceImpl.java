package com.wbd.manager.service.impl;

import java.util.List;
import java.util.Map;

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

	public List<User> pageQueryData(Map<String, Object> map) {

		return userDao.pageQueryData(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		return userDao.pageQueryCount(map);
	}

	public void insert(User user) {
		userDao.insert(user);
		
	}

	public User queryUserById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryUserById( id);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

	public void removeUserById(Integer id) {
		userDao.removeUserById(id);
		
	}

	public void deleteUsers(Map map) {
		userDao.deleteUsers(map);
		
	}

	public void insertUserRoles(Map<String, Object> param) {
		userDao.insertUserRoles(param);
		
	}

	public void deletetUserRoles(Map<String, Object> param) {
		userDao.deletetUserRoles(param);
		
	}

	public List<Integer> queryUserRoleids(Integer id) {
		return userDao.queryUserRoleids(id);
	}

}

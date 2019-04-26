package com.wbd.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.rbac.common.pojo.User;

public interface UserDao {
	
	
	@Select("select * from tb_user")
	List<User> queryAllUser();

	
	@Select("select * from tb_user where account=#{account} and pwd=#{pwd}")
	User queryUserByCondition(User user);
}

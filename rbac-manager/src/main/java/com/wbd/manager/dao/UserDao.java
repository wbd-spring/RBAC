package com.wbd.manager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rbac.common.pojo.User;

public interface UserDao {
	
	
	@Select("select * from tb_user")
	List<User> queryAllUser();

	
	@Select("select * from tb_user where account=#{account} and pwd=#{pwd}")
	User queryUserByCondition(User user);


	List<User> pageQueryData(Map<String, Object> map);


	int pageQueryCount(Map<String, Object> map);

    @Insert("insert into tb_user(account,pwd,username,email,createtime) values(#{account},#{pwd},#{username},#{email},#{createtime})")
	void insert(User user);

    @Select("select * from tb_user where id=#{id}")
	User queryUserById(Integer id);

    @Update("update tb_user set account=#{account},username=#{username},email=#{email} where id=#{id}")
	void updateUser(User user);

    @Delete("delete from tb_user where id=#{id}")
	void removeUserById(Integer id);


	void deleteUsers(Map map);


	void insertUserRoles(Map<String, Object> param);


	void deletetUserRoles(Map<String, Object> param);

    @Select("select role_id from tb_user_role where user_id=#{id}")
	List<Integer> queryUserRoleids(Integer id);
}

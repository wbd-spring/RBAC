package com.wbd.manager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rbac.common.pojo.Role;

public interface RoleDao {

	List<Role> pageQueryData(Map<String, Object> map);


	int pageQueryCount(Map<String, Object> map);


	@Delete("delete from tb_role where id=#{id}")
	void deleteRoleById(Integer id);


	@Insert("insert into tb_role(name) values(#{name})")
	void insertRole(String name);

    @Select("select * from tb_role where id=#{id}")
	Role queryRoleById(Integer id);

    @Update("update tb_role set name=#{name} where id=#{id}")
	void updateRole(Role role);


	void deleteRoles(Map<String, Object> param);

    @Select("select * from tb_role")
	List<Role> queryAllRoles();


	void insertRolePermission(Map<String, Object> param);
	
	@Delete("delete from tb_role_permission where role_id=#{roleid}")
	void deleteRolePermission(Map<String, Object> param);

}

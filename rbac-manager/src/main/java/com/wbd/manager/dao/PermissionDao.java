package com.wbd.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rbac.common.pojo.Permission;

public interface PermissionDao {

	@Select("select * from tb_permission where pid=#{id}")
	List<Permission> queryChildPermission(Integer id);

	@Insert("insert into tb_permission(name,url,pid) values(#{name},#{url},#{pid})")
	void insertPermission(Permission permission);

	@Select("select * from tb_permission where id=#{id}")
	Permission queryPermissionById(Integer id);
    @Update("update tb_permission set name=#{name},url=#{url} where id=#{id}")
	void updatePermission(Permission permission);

    @Delete("delete from tb_permission where id=#{id}")
	void deletePermissionById(Integer id);

    @Select("select * from tb_permission")
	List<Permission> queryAllPermission();

    @Select("select permission_id from tb_role_permission where role_id=#{roleid}")
	List<Integer> queryPermissionByRoleId(Integer roleid);

	List<Permission> queryPermissionByUserId(Integer id);
}

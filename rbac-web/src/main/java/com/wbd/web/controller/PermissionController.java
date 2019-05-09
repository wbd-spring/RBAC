package com.wbd.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbac.common.pojo.AJAXResult;
import com.rbac.common.pojo.Permission;
import com.wbd.manager.service.PermissionService;

@RequestMapping("/permission")
@Controller
public class PermissionController {

	@Autowired
	private PermissionService ps;

	@RequestMapping("/add")
	public String add() {

		return "permission/add";
	}

	@RequestMapping("/edit")
	public String edit(Integer id, Model model) {

		Permission permission = ps.queryPermissionById(id);
		model.addAttribute("permission", permission);

		return "permission/edit";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object edit(Integer id) {

		AJAXResult result = new AJAXResult();

		try {
			ps.deletePermissionById(id);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		return result;
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Permission permission) {
		AJAXResult result = new AJAXResult();

		try {
			ps.insertPermission(permission);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		return result;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Permission permission) {
		AJAXResult result = new AJAXResult();

		try {
			ps.updatePermission(permission);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		return result;
	}

	@RequestMapping("/index")
	public String index() {

		return "permission/index";
	}

	@RequestMapping("/loadAssignData")
	@ResponseBody
	public Object loadAssignData(Integer roleid) {
		List<Permission> resultTreeNodes = new ArrayList<Permission>();

		// 查询所有许可信息
		List<Permission> list = ps.queryAllPermission();

		// 根据角色id查询对应的许可信息id，
		List<Integer> permissionids = ps.queryPermissionByRoleId(roleid);

		Map<Integer, Permission> map = new HashMap<Integer, Permission>();

		for (Permission p : list) {

			if (permissionids.contains(p.getId())) {
				p.setChecked(true);
			} else {

				p.setChecked(false);
			}
			map.put(p.getId(), p);

		}
		
		for(Permission p : list) {
			
			Permission child = p;
			if(child.getPid()==0) {
				resultTreeNodes.add(p);
			}else {
				
				Permission parent = map.get(child.getPid());
				parent.getChildren().add(child);
			}
		}

		return resultTreeNodes;
	}

	@RequestMapping("/loadData")
	@ResponseBody
	public Object loadData() {
//		
		List<Permission> permissions = new ArrayList<Permission>();
//		//模拟数据
////		Permission root = new Permission();
////		root.setName("根目录");
////		
////		Permission child = new Permission();
////		child.setName("子节点");
////		
////		root.getChildren().add(child);
////		
////		permission.add(root);
//		
//				
//				return permission;

		// 通过递归的方式 查询数据

//		Permission parent  = new Permission();
//		parent.setId(0);
//		queryChildPermission(parent);
//		return parent.getChildren();

		List<Permission> list = ps.queryAllPermission();

		Map<Integer, Permission> map = new HashMap<Integer, Permission>();

		for (Permission permission : list) {
			map.put(permission.getId(), permission);

		}

		for (Permission p : list) {
			Permission child = p;
			if (child.getPid() == 0) {
				permissions.add(p);
			} else {
				Permission parent = map.get(child.getPid());
				parent.getChildren().add(child);
			}

		}

		return permissions;

	}

	/**
	 * 递归方法， 通过父permission查询所有的子permission
	 * 
	 * @param parent
	 */
	private void queryChildPermission(Permission parent) {

		List<Permission> childPermissions = ps.queryChildPermission(parent.getId());

		for (Permission permission : childPermissions) {
			queryChildPermission(permission);
		}

		parent.setChildren(childPermissions);

	}
}

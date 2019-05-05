package com.wbd.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbac.common.pojo.AJAXResult;
import com.rbac.common.pojo.Page;
import com.rbac.common.pojo.Role;
import com.wbd.manager.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService rs;

	@RequestMapping("/index")
	public String index() {

		return "role/index";
	}

	@RequestMapping("/add")
	public String add() {

		return "role/add";
	}

	@RequestMapping("/queryPage")
	@ResponseBody
	public Object queryPage(String queryText, Integer pageNum, Integer pageSize) {

		AJAXResult result = new AJAXResult();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (pageNum - 1) * pageSize);
		map.put("size", pageSize);
		map.put("queryText", queryText);

		List<Role> roleList = rs.pageQueryData(map);

		int totalRecord = rs.pageQueryCount(map);

		Page<Role> rolePage = new Page<Role>();

		int totalPage = 0;

		if (totalRecord % pageSize == 0) {
			totalPage = totalRecord / pageSize;
		} else {
			totalPage = totalRecord / pageSize + 1;
		}

		rolePage.setDatas(roleList);
		rolePage.setPageNum(pageNum);
		rolePage.setTotalPage(totalPage);
		rolePage.setTotalRecord(totalRecord);

		result.setData(rolePage);

		result.setSuccess(true);

		return result;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Integer id) {

		AJAXResult result = new AJAXResult();
		rs.deleteRoleById(id);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(String name) {

		AJAXResult result = new AJAXResult();
		rs.insertRole(name);
		result.setSuccess(true);
		return result;
	}

	@RequestMapping("/edit")
	public String edit(Integer id, Model model) {
		Role role = rs.queryRoleById(id);

		model.addAttribute("role", role);

		return "role/edit";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Object update(Role role) {

		AJAXResult result = new AJAXResult();
		rs.updateRole(role);
		result.setSuccess(true);
		return result;

	}

	@RequestMapping("/deleteAllRoles")
	@ResponseBody
	public Object deleteAllRoles(Integer[] roleid) {
		
		System.out.println("iiiiiii......");
		
		AJAXResult result = new AJAXResult();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleids", roleid);
		try {
			
			System.out.println("ttt......");
			rs.deleteRoles(param);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		
		return result;
	}
}

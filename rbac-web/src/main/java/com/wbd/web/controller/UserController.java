package com.wbd.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbac.common.pojo.AJAXResult;
import com.rbac.common.pojo.Page;
import com.rbac.common.pojo.Role;
import com.rbac.common.pojo.User;
import com.wbd.manager.service.RoleService;
import com.wbd.manager.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private RoleService rs;

	/**
	 * 传统的分页方式 分页核心的参数：页码（pageNum），每页显示的条数（pageSize）， 数据库的sql=select *from tb limit
	 * start,pagesize ,start从0开始
	 * 
	 * start = (pagenum-1)*pagesize 因为start从0开始，所以要减1
	 * 
	 */

	
	
	@RequestMapping("/index1")
	public String index(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(required = false, defaultValue = "2") Integer pageSize, Model model) {

		// 通过map进行传值

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", (pageNum - 1) * pageSize);
		map.put("size", pageSize);

		List<User> users = us.pageQueryData(map);

		model.addAttribute("users", users);

		// 当前页码
		model.addAttribute("pageNum", pageNum);

		// 总记录数
		int totalRecord = us.pageQueryCount(map);

		// 总页数
		int totalPage = 0;

		if (totalRecord % pageSize == 0) {

			totalPage = totalRecord / pageSize;

		} else {

			totalPage = totalRecord / pageSize + 1;

		}

		System.out.println("totalPage===" + totalPage);
		// 总页码
		model.addAttribute("totalPage", totalPage);

		// 需要把 总页数和当前页码传入到前台页码，还有总记录，暂时不把总记录数传入到前台页码
		return "user/index";
	}
	
	
	
	/*********************采用AJax异步加载的方式，实现分页 
	 * 
	 *    //采用 AJax异步加载的方式，实现分页，先通过控制器跳转到列表页面， 此时页面没有数据
          //当页面加载完成，然后执行ajax 异步发送 分页请求，得到数据， 再渲染分页数据，提高性能与用户体验
	 *  
	 *  1.先写控制器跳转到列表页面(此时没有分页数据， 分页数据通过ajax异步请求的方式加载然后渲染到页面的分页组件中)
	 *  2.再写一个控制器，接收ajax异步分页请求，最后把数据返回，返回json数据， 然后通过页面的ajax请求 success方法
	 *  对返回的数据进行拼装渲染 对应的分页页面的组件中
	 *  
	 *  
	 *  *****/
	
	
	@RequestMapping("/index")
	public String index() {
		return "user/index";
	}
	
	//该方法对应页面的 Ajax请求（页面请求已经封装了 页码和显示的条数,已经设置的默认值），返回json数据
	@RequestMapping("/queryPage")
	@ResponseBody  //表示方法最后返回json数据
	public Object queryPage(String queryText,Integer pageNum,Integer pageSize) {
		
		AJAXResult  result = new AJAXResult();
		
		// 通过map进行传值

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("start", (pageNum - 1) * pageSize);
		map.put("size", pageSize);
		map.put("queryText", queryText);

		List<User> users = us.pageQueryData(map);


		// 总记录数
		int totalRecord = us.pageQueryCount(map);

		// 总页数
		int totalPage = 0;

		if (totalRecord % pageSize == 0) {

			totalPage = totalRecord / pageSize;

		} else {

			totalPage = totalRecord / pageSize + 1;

		}

		//填充result数据
		
		try {
			Page<User> userPage = new Page<User>();
			userPage.setDatas(users);
			userPage.setPageNum(pageNum);
			userPage.setTotalPage(totalPage);
			userPage.setTotalRecord(totalRecord);
			
			result.setData(userPage);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		
		return result;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(User user) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		AJAXResult  result = new AJAXResult();
		user.setPwd("123456");
		user.setCreatetime(sdf.format(new Date()));
		try {
			us.insert(user);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	
	
	@RequestMapping("/edit")
	public String edit(Integer id,Model model) {
		User user  = us.queryUserById(id);
		model.addAttribute("user", user);
		return "user/edit";
	}
	
	@RequestMapping("/assign")
	public String assign(Integer id,Model model) {
		User user  = us.queryUserById(id);
		
		List<Role> roles = rs.queryAllRoles();
		
		List<Integer> roleids=us.queryUserRoleids(id);
		
		List<Role> unAssignRoles  = new ArrayList<Role>();
		
		List<Role> assignRoles  = new ArrayList<Role>();
		
		for(Role role:roles) {
			
			if(roleids.contains(role.getId())) {
				
				assignRoles.add(role);
			}else {
				
				unAssignRoles.add(role);
			}
			
			
		}
		
		model.addAttribute("user", user);
		model.addAttribute("assignRoles", assignRoles);
		model.addAttribute("unAssignRoles", unAssignRoles); 
		return "user/assign";
	}
	
	@RequestMapping("/update")
	@ResponseBody 
	public Object update(User user) {
		AJAXResult  result = new AJAXResult();
		
		try {
			us.updateUser(user);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(true);
		}
		
		return result;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(Integer id) {
		AJAXResult  result = new AJAXResult();
		
		try {
			us.removeUserById(id);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	
	@RequestMapping("/doAssign")
	@ResponseBody
	public Object deleteUsers(Integer userid,Integer[] unassignroleids) {
		AJAXResult  result = new AJAXResult();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userid", userid);
		param.put("unassignroleids", unassignroleids);
		try {
			us.insertUserRoles(param);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	@RequestMapping("/dounAssign")
	@ResponseBody
	public Object dounAssign(Integer userid,Integer[] assignroleids) {
		
		AJAXResult  result = new AJAXResult();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userid", userid);
		param.put("assignroleids", assignroleids);
		try {
			us.deletetUserRoles(param);
		
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	
	@RequestMapping("/deleteUsers")
	@ResponseBody
	public Object deleteUsers(Integer[] userid) {
		
		AJAXResult  result = new AJAXResult();
		
		try {
			
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("userids", userid);
			
			us.deleteUsers(param);
			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
	}
	

}

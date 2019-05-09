package com.wbd.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rbac.common.pojo.AJAXResult;
import com.rbac.common.pojo.Permission;
import com.rbac.common.pojo.User;
import com.wbd.manager.service.PermissionService;
import com.wbd.manager.service.UserService;

@Controller
public class IndexController {

	@Autowired
	private UserService us;
	
	@Autowired
	private PermissionService ps;

	@RequestMapping("/login")
	public String index() {
		return "login"; // 重定向到 login.jsp页面
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(User user, Model model) {

		System.out.println(user.getAccount()+".....");
		User dbuser = us.queryUserByConditon(user);
 
		if (dbuser != null) {
			return "main"; // springmvc默认才去请求转发的方式， 这里是转发到main.jsp，地址栏不改变,地址栏还是请求的doLogin地址
		}

		String errorMsg = "账号或者密码错误，请重新登录";
		model.addAttribute("errorMsg", errorMsg);
		// 重定向到 login.jsp页面，顺便把参数也带出去，地址栏会改变，直接到jsp页面
		return "redirect:login"; 

	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:/login"; // 重定向到/login控制器，而/login控制器直接重定向到 login.jsp页面,地址栏改变，变成登录页面
	}
	
	
	@RequestMapping(value = "/doAjaxLogin", method = RequestMethod.POST)
	@ResponseBody
	public Object doAjaxLogin(User user, Model model,HttpSession session) {
		AJAXResult  result = new AJAXResult();
		User dbuser = us.queryUserByConditon(user);
		 
		if (dbuser != null) {
			session.setAttribute("loginUser", dbuser);
			//只有用户登录成功之后， 才把用户信息存入到session，系统菜单动态加载， 通过用户获取对应的许可的菜单
			//通过用户id查询用户授权的菜单， 需要关联三张表,user,role,permission
			
			List<Permission> userPermission = ps.queryPermissionByUserId(dbuser.getId());
			
			//下面的过程是把从数据库中获取到许可进行 对象化， 并且组装成有父子关系的许可，然后存入session中，
			//在通过前台页面进行渲染出来
			Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
			Permission  root = null;
			for(Permission p:userPermission)
			{
				
				permissionMap.put(p.getId(), p);
			}
			
			for(Permission p:userPermission)
			{
				Permission child = p;
				if(child.getPid()==0) {
					root = p;
				}else {
					
					Permission  parent= 	permissionMap.get(child.getPid());
					
					parent.getChildren().add(child);
				}
				
			}
			//存入session中
			session.setAttribute("rootPermission", root);

			result.setSuccess(true);
			
		}else {
			
			result.setSuccess(false);
		}
		
		return result; 
	}
	
	
	@RequestMapping("/main")
	public String main() {
		return "main"; // 请求转发到 main.jsp页面
	}
	
	@RequestMapping("/test")
	public String test() {
		return "/test1"; // 请求转发到test1.jsp页面   ,return /test1  和 return test1结果是一样的，默认都是请求转发，地址栏还是以前的地址
		
		
		
		
	}
	
	@RequestMapping("/test2")
	public String test2(Model model) {
		model.addAttribute("a", "abc");  //重定向可以吧值带出去
		//重定向。是重定向到一个控制器中,地址会改变， 是最后的重定向地址redirect:test = redirect:/test
		return "redirect:test"; 
	}

}

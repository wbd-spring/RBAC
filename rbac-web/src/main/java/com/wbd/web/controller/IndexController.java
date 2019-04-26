package com.wbd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rbac.common.pojo.User;
import com.wbd.manager.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService us;

	@RequestMapping("/login")
	public String index() {
		return "login"; //重定向到 login.jsp页面
	}
	
	@RequestMapping(value="/doLogin",method=RequestMethod.POST)
	public String doLogin(User user,Model model) {
		System.out.println(user.getAccount());
		System.out.println(user.getPwd());
		User dbuser = us.queryUserByConditon(user);
		System.out.println("dbuser==="+dbuser);
		if(dbuser!=null) {
			return "main"; //springmvc默认才去请求转发的方式， 这里是转发到main.jsp，地址栏不改变
		}
		
		String errorMsg = "账号或者密码错误，请重新登录";
		model.addAttribute("errorMsg", errorMsg);
		return "redirect:login"; //重定向到 login.jsp页面，顺便把参数也带出去，地址栏会改变
	}

}

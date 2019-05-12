package com.wbd.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rbac.common.pojo.User;

public class LoginInteceptor implements HandlerInterceptor{

	//进入action之前执行的方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User loginUser = 	(User) session.getAttribute("loginUser");
		if(loginUser==null) {
			
		String webPath = 	session.getServletContext().getContextPath();
		response.sendRedirect(webPath+"/login");
		return false;
		}else {
		return true;
		}
	}

	//action执行完毕之后的方法
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("login--action执行完毕之后的方法");
		
	}

	//完成试图渲染之后执行的方法
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("login--afterCompletion完成试图渲染之后执行的方法");
	}

}

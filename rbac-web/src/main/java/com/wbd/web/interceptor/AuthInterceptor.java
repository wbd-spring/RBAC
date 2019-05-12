package com.wbd.web.interceptor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rbac.common.pojo.Permission;
import com.wbd.manager.service.PermissionService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private PermissionService  ps;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		System.out.println("当前请求的uri==="+uri);
		String webPath = request.getSession().getServletContext().getContextPath();
		System.out.println("当前web app项目的名称为........"+webPath);
		
		//查询所有需要验证的路径集合
		List<Permission> permissions = ps.queryAllPermission();
		
		Set<String> uriSet = new HashSet<String>();
		
		for (Permission p : permissions) {
			if ( p.getUrl() != null && !"".equals(p.getUrl()) ) {
				uriSet.add(webPath + p.getUrl());
			}
		}
		
		if(uriSet.contains(uri)) {
			
			Set<String> authUriSet = (Set<String>) request.getSession().getAttribute("authUriSet"); 
			
			if(authUriSet.contains(uri)) {
				
				return true;
			}else {
				
				response.sendRedirect(webPath+"/error");
				return false;
				
			}
		}else {
			
			return true;
		}
		
		
	}

}

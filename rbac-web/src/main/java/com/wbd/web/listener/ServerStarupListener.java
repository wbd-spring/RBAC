package com.wbd.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * servelt的监听器，当服务器启动时，开启启动，spring的启动 监听器也是实现了ServeltContextListener接口，
 * @author zgh
 *
 */
public class ServerStarupListener implements ServletContextListener {

	/**
	 * 初始化时，获取当前项目名称，然后放到application中， 用来设置页面的静态资源(js，css,png等等)请求路径
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	 
		//获取application
		ServletContext application  = sce.getServletContext();
		
		//通过应用获取当前应用的路径
		String path = application.getContextPath();
		
		System.out.println("当前应用的路径....."+path);
		
		//放入到application中
		
		application.setAttribute("APP_PATH", path);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	

	}

}

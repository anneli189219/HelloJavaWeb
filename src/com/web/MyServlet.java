package com.web;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <p>Title: MyServlet</p>  
 * <p>Description: 实现Servlet方式之实现Servlet接口</p>  
 * @author  wpf  
 * @date  2019年10月10日
 */
public class MyServlet implements Servlet{
	private ServletContext context;
	//重写了Servlet接口的五个方法
	@Override
	public void destroy() {
		System.out.println("正在销毁");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化servlet");
		//获取一个初始化参数
		String name = arg0.getInitParameter("name");
		System.out.println(name);
		//获取一系列初始化参数<枚举>
		Enumeration<String> parameterNames = arg0.getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String namep = (String) parameterNames.nextElement();
			String value = arg0.getInitParameter(namep);
			System.out.println(namep+":"+value);
			
		}
		//获取ServletContext对象，作用域是整个web应用，每个Servlet共享同一个ServletContext对象
		context = arg0.getServletContext();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("Servlet进入服务");
		HttpServletResponse response=(HttpServletResponse) arg1;
		response.getWriter().write("hello");
		context.setAttribute("apple","green");
		//在另一个Servlet中使用context.getAttribute(""),是否能得到相应的值？
		response.getWriter().write(context.getInitParameter("name"));
		//不应把所有参数都配置在web.xml中
		Properties pro=new Properties();
		pro.load(new FileReader(context.getRealPath("aaa.properties")));//注意路径
	}

}

package com.web;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <p>Title: MyServlet</p>  
 * <p>Description: 实现Servlet方式之继承GenericServlet</p>  
 * @author  wpf  
 * @date  2019年10月10日
 */
public class MyServlet1 extends MyGenericServlet{
	//无法判断是post\get请求
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String value = getServletConfig().getServletContext().getInitParameter("name");
		System.out.println(value);
		//请求方法类型
//		HttpServletRequest hreq=(HttpServletRequest) req;
//		String method = hreq.getMethod();
//		if(method.equalsIgnoreCase("GET")){
//			
//		}else if(method.equalsIgnoreCase("POST")){
//			
//		}
//		System.out.println(method);
//		每个Servlet都需要这样判断会比较麻烦，那可以把它们封装起来
	}
	
	
	

}

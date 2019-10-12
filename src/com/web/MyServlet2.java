package com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <p>Title: MyServlet2</p>  
 * <p>Description: 实现Servlet方式之继承HttpServlet</p>  
 * @author  wpf  
 * @date  2019年10月10日
 */
public class MyServlet2 extends MyHttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest hreq, HttpServletResponse hres) {
		String value = getServletConfig().getServletContext().getInitParameter("name");
		System.out.println(value);
	}
	
}

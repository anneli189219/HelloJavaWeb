package com.web;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * <p>Title: MyGenericServlet</p>  
 * <p>Description: 自定义GenericServlet类</p>  
 * @author  wpf  
 * @date  2019年10月10日
 */
public abstract class MyGenericServlet implements Servlet{
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return this.config;
	}

	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException ;
		
		
	

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

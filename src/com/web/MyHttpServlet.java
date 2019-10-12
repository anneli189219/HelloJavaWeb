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
 * <p>Title: MyHttpServlet</p>  
 * <p>Description: 自定义HttpServlet类</p>  
 * @author  wpf  
 * @date  2019年10月10日
 */
public class MyHttpServlet extends GenericServlet{
	
	private static final long serialVersionUID = 1L;

	//对浏览器发送的请求进行判断,实现对每个请求的处理进行分离
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			HttpServletRequest hreq=(HttpServletRequest) req;
			HttpServletResponse hres=(HttpServletResponse) res;
			service(hreq,hres);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	//方法名相同，但参数类型不同
	public void service(HttpServletRequest hreq, HttpServletResponse hres) throws ServletException, IOException {
		String method = hreq.getMethod();
		System.out.println(method);
		if(method.equalsIgnoreCase("GET")){
			doGet(hreq,hres);
		}else if(method.equalsIgnoreCase("POST")){
			doPost(hreq,hres);
		}
		
		
	}
	protected void doPost(HttpServletRequest hreq, HttpServletResponse hres) {
		// TODO Auto-generated method stub
		
	}
	protected void doGet(HttpServletRequest hreq, HttpServletResponse hres) {
		// TODO Auto-generated method stub
		
	}
	

}

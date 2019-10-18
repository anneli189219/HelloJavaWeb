package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 
 * <p>Title: DemoFilter</p>  
 * <p>Description: 过滤器实现类</p>  
 * @author  wpf  
 * @date  2019年10月16日
 */
//@WebFilter("/*")
public class DemoFilter implements Filter{
	/*
	 * 过滤器两步走战略：
	 * 1.编写Java实现类实现Filter接口，并实现其doFilter()方法；
	 * 2.在web.xml文件中配置<filter>和<filter-mapping>
	 * 过滤器的生命周期--->由web服务器控制
	 * a.服务器启动时，创建Filter实例对象，调用其init方法，完成初始化操作，Filter对象只创建一次
	 *   init方法只会执行一次；
	 * b.拦截到请求时，执行doFilter()方法，可执行多次；
	 * c.服务器关闭时，服务器销毁Filter对象；
	 * 过滤器的执行顺序：
	 * 与<filter-mapping>有关(谁在前执行谁)，与过滤器在web.xml文件中配置的顺序无关
	 * 如果配置多个过滤器会形成过滤器链，它们的请求路径相同，那它的执行顺序又是什么呢？
	 * web容器加载、销毁时，与<filter-mapping>配置顺序相反；
	 * 过滤器执行时，与<filter-mapping>配置顺序相同。
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获取web.xml文件中<fiter>元素初始化参数的值
		System.out.println("初始化方法1");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("执行该过滤器1");
		chain.doFilter(request, response);//放行请求及响应资源
		
	}

	@Override
	public void destroy() {
		System.out.println("销毁方法1");
		
	}

}

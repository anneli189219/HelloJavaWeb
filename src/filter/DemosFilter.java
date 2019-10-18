package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * <p>Title: DemosFilter</p>  
 * <p>Description: 验证用户是否登录，未登录是不能直接访问主页面</p>  
 * @author  wpf  
 * @date  2019年10月16日
 */
//@WebFilter("/*")
public class DemosFilter implements Filter {

    /**
     * Default constructor. 
     */
    public DemosFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("销毁方法2");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("执行过滤器2");
		//强制类型转换，把ServletRequest转换为HttpServletRequest
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		//获取请求路径，注意request.getRequestURL()与request.getRequestURI()的区别
		StringBuffer url = req.getRequestURL();
		String uri = req.getRequestURI();
		System.out.println(url);
		System.out.println(uri);//注意这两条打印语句的区别
		//判断请求路径是否是以/main.jsp结尾
		if(uri.endsWith("/main.jsp")){
			String name = (String) req.getSession().getAttribute("name");
			System.out.println("name的值为"+name);
			//判断是否登录,如果name等于空，说明没有登录，跳转到登录界面，反之已登录可以直接访问主页面
			if(name==null){
				res.sendRedirect("login.jsp");
			}
		}else{
			System.out.println("路径报错");
		}
		chain.doFilter(request, response);//放行请求及响应资源
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化方法2");
	}

}

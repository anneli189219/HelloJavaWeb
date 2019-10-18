package listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * <p>Title: ServletContextListenerImpl</p>  
 * <p>Description: application作用域对应的监听器实现类</p>  
 * @author  wpf  
 * @date  2019年10月16日
 */
//@WebListener
public class ServletContextListenerImpl implements ServletContextListener,ServletContextAttributeListener{
	/*
	 * 监听器(Listener):用于监听web应用中某些对象，信息的创建、销毁、增加、修改、删除等动作发生时，
	 * 然后做出相应的响应处理，当范围对象的状态发生变化时，服务器自动调用监听器对象中的方法。
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		//通过事件对象得到作用域内的参数名称以及它的值，getName()、getValue()
		System.out.println("application作用域对象添加啦");
		String path = (String) scae.getServletContext().getAttribute("name");
		String name = scae.getName();
		String value = (String) scae.getValue();
		System.out.println(path+":"+name+":"+value);
		scae.getServletContext().setAttribute("name", "www");
		scae.getServletContext().removeAttribute("name");
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("application作用域对象移除啦");
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("application作用域对象修改啦");
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("web容器初始化");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("web容器销毁");
		
	}

}

package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * <p>Title: HttpSessionListenerImpl</p>  
 * <p>Description: Session作用域所对应监听器的实现类</p>  
 * @author  wpf  
 * @date  2019年10月16日
 */
//@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener,HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		//通过事件对象得到作用域内的参数名称以及它的值，getName()、getValue()
		System.out.println("session作用域对象添加啦");
		String name = se.getName();
		String value = (String) se.getValue();
		System.out.println(name+":"+value);
		se.getSession().setAttribute("name", "ddd");
		se.getSession().removeAttribute("name");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("session作用域对象移除啦");
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("session作用域对象修改啦");
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session会话开启");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session会话结束");
		
	}

}

package listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 
 * <p>Title: ServletRequestListenerImpl</p>  
 * <p>Description: Request作用域所对应监听器的实现类</p>  
 * @author  wpf  
 * @date  2019年10月16日
 */
//@WebListener
public class ServletRequestListenerImpl implements ServletRequestListener,ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		//通过事件对象得到作用域内的参数名称以及它的值，getName()、getValue()
		System.out.println("request作用域对象添加啦");
		String name = srae.getName();
		String value = (String) srae.getValue();
		System.out.println(name+":"+value);
		srae.getServletRequest().setAttribute("name", "yyy");
		srae.getServletRequest().removeAttribute("name");
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request作用域对象移除啦");
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request作用域对象修改啦");
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request请求销毁");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request请求开始");
		
	}

}

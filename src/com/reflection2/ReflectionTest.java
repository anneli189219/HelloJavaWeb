package com.reflection2;

import com.reflection1.Person;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * <p>Title: ReflectionTest</p>  
 * <p>Description:调用运行时类中指定的结构：属性、方法、构造器 </p>  
 * @author  wpf  
 * @date  2019年10月8日
 */
public class ReflectionTest {
	public static void main(String[] args) {
		testField();
		testField1();
		testMethod();
		testConstructor();
	}

   
    public static void testField()  {
		Class clazz = Person.class;

		try {
			// 创建运行时类的对象
			Person p = (Person) clazz.newInstance();

			// 获取指定的属性：要求运行时类中属性声明为public
			// 通常不采用此方法
			Field id = clazz.getField("id");

			/*
			 * 设置当前属性的值 
			 * set():参数1：指明设置哪个对象的属性 参数2：将此属性值设置为多少
			 */
			id.set(p, 1001);

			/*
			 * 获取当前属性的值 
			 * get():参数1：获取哪个对象的当前属性值
			 */
			int pId = (int) id.get(p);
			System.out.println(pId);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}


    }
    /*
              如何操作运行时类中的指定的属性 -- 需要掌握
     */
    public static void testField1()  {
		Class clazz = Person.class;
		try {
			// 创建运行时类的对象
			Person p = (Person) clazz.newInstance();

			// 1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
			Field name = clazz.getDeclaredField("name");
			// 2.保证当前属性是可访问的,若2为false,3会执行成功吗
			name.setAccessible(true);
			// 3.获取、设置指定对象的此属性值
			name.set(p, "Tom");

			System.out.println(name.get(p));
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }

    /*
              如何操作运行时类中的指定的方法 -- 需要掌握
     */
    public static void testMethod() {

		Class clazz = Person.class;
		try {
			// 创建运行时类的对象
			Person p = (Person) clazz.newInstance();
			/*
			 * 1.获取指定的某个方法 
			 * getDeclaredMethod():参数1 ：指明获取的方法的名称 参数2：指明获取的方法的形参列表
			 */
			Method show = clazz.getDeclaredMethod("show", String.class);
			// 2.保证当前方法是可访问的
			show.setAccessible(true);
			/*
			 * 3. 调用方法的invoke():参数1：方法的调用者 参数2：给方法形参赋值的实参
			 * invoke()的返回值即为对应类中调用的方法的返回值。
			 */
			Object returnValue = show.invoke(p, "CHN"); // String nation =p.show("CHN");
			System.out.println(returnValue);

			System.out.println("*************如何调用静态方法*****************");

			// private static void showDesc()

			Method showDesc = clazz.getDeclaredMethod("showDesc");
			showDesc.setAccessible(true);
			// 如果调用的运行时类中的方法没有返回值，则此invoke()返回null
			// Object returnVal = showDesc.invoke(null);
			Object returnVal = showDesc.invoke(Person.class);
			System.out.println(returnVal);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}

    }

    /*
               如何调用运行时类中的指定的构造器(不通用)
     */
    public static void testConstructor() {
        Class clazz = Person.class;

        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */

        try {
			Constructor constructor = clazz.getDeclaredConstructor(String.class);
			//2.保证此构造器是可访问的
			constructor.setAccessible(true);
			//3.调用此构造器创建运行时类的对象
			Person per = (Person) constructor.newInstance("Tom");
			System.out.println(per);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}

    }

}

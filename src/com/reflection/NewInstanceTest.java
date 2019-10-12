package com.reflection;

import java.util.Random;

/**
 * 
 * <p>Title: NewInstanceTest</p>  
 * <p>Description:通过反射创建对应的运行时类的对象 </p>  
 * @author  wpf  
 * @date  2019年10月8日
 */
public class NewInstanceTest {
	
	public static void main(String[] args) {
		//test1();
		test2();
	}

    
    public static void test1()  {

        Class<Person> clazz = Person.class;
        /*
        newInstance():调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参的构造器。(通用)
 	        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常，设置为public。


                 在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器

        */
        Person obj;
		try {
			obj = clazz.newInstance();
			System.out.println(obj);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }

    //体会反射的动态性(*)--->通用结构
    public static void test2(){

        for(int i = 0;i < 100;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.reflection.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
    public static Object getInstance(String classPath) throws Exception {
       Class clazz =  Class.forName(classPath);
       return clazz.newInstance();
    }

}

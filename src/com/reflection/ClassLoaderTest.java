package com.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * <p>Title: ClassLoaderTest</p>  
 * <p>Description: 了解类的加载器</p>  
 * @author  wpf  
 * @date  2019年10月8日
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		test1();
		test2();
		
	}

    
    public static void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);//没有获取到

    }
    /*
    Properties：用来读取配置文件。

     */
    public static void test2() {

        Properties pros =  new Properties();
        //读取配置文件的方式一：
        try {
			FileInputStream fis = new FileInputStream("dbcp.properties");
			pros.load(fis);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前工程的src下
//        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("dbcp.properties");
//        try {
//			pros.load(is);
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}


        String user = pros.getProperty("username");
        String password = pros.getProperty("password");
        System.out.println("username = " + user + ",password = " + password);



    }

}

package com.reflection2;

import com.reflection1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import java.lang.reflect.Type;
/**
 * 
 * <p>Title: ReflectionTest</p>  
 * <p>Description:获取其他结构</p>  
 * @author  wpf  
 * @date  2019年10月8日
 */
public class OtherTest {
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
    /*
              获取构造器结构

     */
    public static void test1(){

        Class clazz = Person.class;
        //getConstructors():获取当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }

    }

    /*
             获取运行时类的父类

     */
    public static void test2(){
        Class clazz = Person.class;
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
              获取运行时类的带泛型的父类

     */
    public static void test3(){
        Class clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }


    /*
             获取运行时类实现的接口
     */
    public static void test4(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }

        System.out.println();
        //获取运行时类的父类实现的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }

    }
    /*
              获取运行时类所在的包

     */
    public static void test5(){
        Class clazz = Person.class;
        Package pack = clazz.getPackage();
        System.out.println(pack);
    }

    /*
             获取运行时类声明的注解(框架使用)

     */
    public static void test6(){
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annos : annotations){
            System.out.println(annos);
        }
    }

}

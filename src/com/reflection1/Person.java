package com.reflection1;

/**
 * 
 * <p>Title: Person</p>  
 * <p>Description: 人</p>  
 * @author  wpf  
 * @date  2019年10月8日
 */
@MyAnnotation(value="hi")
public class Person extends Creature<String> implements MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){}

    @MyAnnotation(value="abc")
    private Person(String name){
        this.name = name;
    }

     Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests,int age) throws NullPointerException,ClassCastException{
        return interests + age;
    }


    @Override
    public void info() {
        System.out.println("我是一个人");
    }


    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

    
}

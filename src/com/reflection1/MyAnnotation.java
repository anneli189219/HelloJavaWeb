package com.reflection1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 
 * <p>Title: MyAnnotation</p>  
 * <p>Description: 注解接口</p>  
 * @author  wpf  
 * @date  2019年10月8日
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	//SuppressWarnings接口
    String value() default "hello";

}

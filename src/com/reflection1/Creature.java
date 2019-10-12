package com.reflection1;

import java.io.Serializable;

/**
 * 
 * <p>Title: Creature</p>  
 * <p>Description: 生物</p>  
 * @author  wpf  
 * @date  2019年10月8日
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }

}

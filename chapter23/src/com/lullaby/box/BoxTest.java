package com.lullaby.box;

public class BoxTest {

    public static void main(String[] args) {
        // 变量number1需要的是一个对象，但赋值的时候给的是一个基本数据类型int值
        // 编译器就会将这个int值进行包装，调用Integer.valueOf(5)进行包装
        Integer number1 = 5;    // Integer.valueOf(5)

        // 变量number2需要的是一个基本数据类型值，但是赋值的时候给的却是一个对象
        // 编译器就会将这个对象进行解包，调用number1.intValue();进行解包
        int number2 = number1;

        Double d1 = 5.0;    // Double.valueOf(5.0)
        double d2 = d1;     // Double.doubleValue()
    }
}

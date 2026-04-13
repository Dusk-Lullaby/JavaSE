package com.Sonnet.Example;

public class Example8 {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "World";
        ///会产生新的对象
        String s3 = s1 + s2;
        System.out.println(s3);
        //concat:连接
        //将s2追加到s1的末尾
        //也会产生新的对象
        String s4 = s1.concat(s2);
        System.out.println(s4);

        String s5 = "    ab  cde";
        //将字符串两端的空格修剪掉,中间还在
        String s6 = s5.trim();
        System.out.println(s5);
        System.out.println(s6);
    }
}

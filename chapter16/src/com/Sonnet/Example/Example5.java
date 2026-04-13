package com.Sonnet.Example;

public class Example5 {

    public static void main(String[] args) {
        String s = "java是世界上最好的语言.cpp";

        //字符串截取，截取时，使用的是左闭右开区间[0, 4)
        //即取头不取尾
        String sub1 = s.substring(0, 3);
        System.out.println(sub1);
        //从下标7开始，一直向后截取
        String sub2 = s.substring(7);
        System.out.println(sub2);
    }
}

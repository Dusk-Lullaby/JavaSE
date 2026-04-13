package com.Sonnet.Example;

public class Example1 {

    public static void main(String[] args) {

        //当使用一个字面量给字符串赋值时，首先会去字符串常量池中检测是否存在
        //如果存在，则直接使用这个字面量的地址值赋值即可。
        //如果不存在，则需要在字符串常量池中创建这个字面量，然后再将地址赋值
        String s = "超用心";
        s += "在线教育";    //这里的字符串拼接再堆内存上
        System.out.println(s);
    }
}

package com.Sonnet.Example;

public class Example4 {

    public static void main(String[] args) {
        String s = "jiaxinbinggan@qq.com";

        //求指定字符在字符串中第一次出现下标的位置
        //相互兼容的数据类型之间可以自动发生类型转换，char --> int
        int index1 = s.indexOf('@');
        System.out.println(index1);
        //求指定字符在字符串中最后一次出现下标的位置
        int index2 = s.lastIndexOf('@');
        System.out.println(index2);
        if (index1 == index2)  {
            System.out.println("字符串" + s + "只存在一个" + "@" );
        }
        //获取字符串中指定下标的字符
        char ch = s.charAt(13);
        System.out.println(ch);
    }
}

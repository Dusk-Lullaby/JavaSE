package com.Sonnet.Example;

public class Example3 {

    public static void main(String[] args) {
        String s1 = "超用心在线教育";

        //获取字符串的长度
        int length = s1.length();
        System.out.println(length);

        String s2 = "abc";
        String s3 = "abc";
        String s4 = "ABC";
        System.out.println(s2 == s3);
        //字符串之间进行比较时，首先会查看两个字符串的长度是否一致，如果一致，再看其中的每一个字符是否相同
        System.out.println(s2.equals(s3));
        System.out.println(s2.equals(s4));
        System.out.println(s2.equalsIgnoreCase(s4));

        //upper：向上，转大写
        String s5 = s2.toUpperCase();
        System.out.println(s5);
        //lower：向下，转小写
        String s6 = s4.toLowerCase();
        System.out.println(s6);
    }
}

package com.Sonnet.Example;

public class Example6 {

    public static void main(String[] args) {

        String s = "Hello world";
        String s1 = s.replace('o', 'a');
        //并不会改变原有的字符串
        System.out.println(s);
        System.out.println(s1);

        //注意：
        //即便是String类型也可以，因为target的类型是CharSequence，而字符串也是CharSequence的一个类型
        String s2 = s.replace("o", "a");
        System.out.println(s2);

        String info = "a1b2c3d4f5";
        //regular expression --- 正则表达式
        //三位整数的正则表达数 099 [0123456789][0123456789][01234567890]
        //[1-9][0-9]{2,2} --- 第一位在1-9，紧接的2位在0-9
        //三只五位整数的正则表达式
        //[1-9][0-9]{2,4}
        //英文字符串的正则表达式
        //[a-zA-Z]+  --- + 表示任意几位
        //英文字符串加数字的正则表达式
        //[a-zA-Z0-9]
        String result1 = info.replaceAll("[a-zA-Z]","");
        System.out.println(result1);
        String result2 = info.replaceAll("[0-9]","");
        System.out.println(result2);
    }
}

package com.Sonnet.Example;

public class Example14 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("admin");

        sb.reverse();
        System.out.println(sb);

        sb.insert(2, ",");  //在偏移量后面插入一个字符串
        System.out.println(sb);
        //需要注意的是：length（）方法返回的是char[]中使用的数量
        System.out.println(sb.length());

        StringBuilder sb2 = new StringBuilder("abababa");
        int index1 = sb2.indexOf("ab");
        int index2 = sb2.lastIndexOf("ab");
        System.out.println(index1);
        System.out.println(index2);
    }
}

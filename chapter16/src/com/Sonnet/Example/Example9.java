package com.Sonnet.Example;

public class Example9 {

    public static void main(String[] args) {
        //字符串分割
        String s = "a1b2cc3d4f5";//[a-z0-9]+  or  [a-z0-9]{10,10}
        String[] arr = s.split("[0-9]");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        String personInfo = "刘德华,男,53, 很帅气";
        String[] arr2 = personInfo.split(",");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        //检测字符串是否匹配给定的正则表达式
        String regex = "[a-z0-9]+";
        boolean match = s.matches(regex);
        System.out.println(match);
    }
}

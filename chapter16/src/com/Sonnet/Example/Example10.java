package com.Sonnet.Example;

public class Example10 {
    public static void main(String[] args) {
        String s1 = "夹心饼干";
        String s2 = "真好吃";
        String s3 = s1 + s2;

        String s5 = s3.intern();

        String s4 = "夹心饼干真好吃";
        System.out.println(s3 == s4);
        System.out.println(s5 == s4);
    }
}

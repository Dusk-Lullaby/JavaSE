package com.Sonnet.Example;

public class Example13 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdefg");
        sb.delete(1, 5);
        //左闭右开
        System.out.println(sb);

        sb.deleteCharAt(1);
        System.out.println(sb);
    }
}

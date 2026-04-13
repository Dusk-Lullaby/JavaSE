package com.Sonnet.Example;

public class Example15 {

    public static void main(String[] args) {
        String str = "ababababababa";
        int n = 0;
        while(str.indexOf("aba") != str.lastIndexOf("aba")) {
            str = str.replace("aba", "cba");
            n++;
        }
        System.out.println(n + 1);
    }
}
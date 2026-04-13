package com.Sonnet.example;

public class Example5 {

    public static void main(String[] args) {
        int result = getResult();
        System.out.println(result);
    }

    public static int getResult() {
        int number = 10;
        try {//尝试执行，尝试返回
            return number;
        } catch (Exception e) {
            return 1;
        } finally {

            return ++number;
        }
    }
}

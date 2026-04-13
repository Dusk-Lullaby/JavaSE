package com.Sonnet.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int number1 = getNumber();
        int number2 = getNumber();
        int number = divide(number1, number2);
        System.out.println(number);
    }

    public static int divide (int a, int b) throws InputMismatchException, AbstractMethodError{
        return a / b;
    }

    //执行该方法可能会抛出InputMismatchException---输入不匹配异常
    public static int getNumber() throws InputMismatchException {
        System.out.println("请输入一个数字");
        int number = sc.nextInt();
        return number;
    }
}

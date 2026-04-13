package com.Sonnet.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            int number = sc.nextInt();
            System.out.println(number);
        } catch(InputMismatchException e) {
            //打印异常轨迹
//            e.printStackTrace();            																		System.out.println(e.getClass().getName());
            System.out.println("异常信息：" + e.getMessage());
            System.out.println("请不要瞎写，只能输入数字");
        }
        System.out.println("发生异常也会执行");
    }

}

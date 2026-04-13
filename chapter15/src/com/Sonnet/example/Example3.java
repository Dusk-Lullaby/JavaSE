package com.Sonnet.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example3 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num = divide();
        System.out.println(num);
    }

    public static int divide() throws InputMismatchException, ArithmeticException {
        try {
            int number1 = getNumber();
            int number2 = getNumber();
            return number1 / number2;
        } catch(InputMismatchException e) {
            System.out.println("请不要乱输入，只能输入数字");
        } catch(ArithmeticException e) {
            System.out.println("除法运算中0不能当除数");
        }
        return 0;
    }


    public static int getNumber() throws InputMismatchException {
        System.out.println("请输入一个数字");
        int number = sc.nextInt();
        return number;
    }

}

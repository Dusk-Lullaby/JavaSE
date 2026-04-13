package com.Sonnet.Example;

import java.util.Scanner;

public class Example16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
        double money = sc.nextDouble();
        StringBuilder sb = new StringBuilder().append(money);
        int index = sb.indexOf(".");
        if (index > 3) {
            for (int i = index -3; i > 0; i -= 3) {
                sb.insert(i, ",");
            }
        }
        System.out.println(sb);
    }

}

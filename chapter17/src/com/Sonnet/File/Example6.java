package com.Sonnet.File;

import java.util.Scanner;

public class Example6 {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        gotoLogin();
    }

    public static void gotoLogin() {
        System.out.println("请输入菜单编号:");
        int number = sc.nextInt();
        if (number == 1) {
            getMain();
        } else {
            System.out.println("exit");
            System.exit(0);
        }
    }

    public static void getMain() {
        System.out.println("请输入菜单的编号:");
        int number = sc.nextInt();
        if (number == 6) {
            gotoLogin();
        } else {
            System.out.println("你选择了其他菜单");
        }
    }
}

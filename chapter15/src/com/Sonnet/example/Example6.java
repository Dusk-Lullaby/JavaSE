package com.Sonnet.example;

import java.util.Scanner;

public class Example6 {

    private static Scanner sc = new Scanner(System.in);

    private static int[] number = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) {
        System.out.println("请输入账号");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();

        //检查异常，必须要做处理
        try {
            login(username, password);
        } catch (UsernameNoFoundException e) {
            e.printStackTrace();
        } catch (BadCredentialException e) {
            e.printStackTrace();
        }

        //数组越界了，但是可以自动恢复
        System.out.println(number[6]);
    }

    public static void login(String username, String password) throws UsernameNoFoundException, BadCredentialException {
        if ("admin".equals(username)) {
            if ("123456".equals(password)) {
                System.out.println("登录成功");
            } else {
                throw new BadCredentialException("账号或密码错误");
            }
        } else {
            throw new UsernameNoFoundException("账号不存在");
        }
    }
}

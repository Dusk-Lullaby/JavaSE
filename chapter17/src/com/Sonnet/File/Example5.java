package com.Sonnet.File;

/**
 * 递归求和
 */
public class Example5 {
    public static void main(String[] args) {
        System.out.println(addSum(100));

    }

    public static int addSum(int n) {
        if (n == 1) return 1;
        return n + addSum(--n);
    }
}

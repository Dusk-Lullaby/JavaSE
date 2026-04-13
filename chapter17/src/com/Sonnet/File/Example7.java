package com.Sonnet.File;

public class Example7 {
    public static void main(String[] args) {
        System.out.println(Steps(6));
    }

    public static int Steps(int n) {
        if (n == 1 || n == 0) return 1;
        return n * Steps(n - 1);
    }
}

package com.Sonnet.example;

public class Example4 {

    private static int[] numbers = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        try {
            //数组越界
            int number = getNumberArray(10);
            System.out.println(number);
            //系统正常退出，如果非0，那么是异常退出
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组下标越界了");
            System.exit(0);
        } finally {
            System.out.println("需要执行的代码");
        }
    }

    public static int getNumberArray (int index) {
        return numbers[index];
    }
}

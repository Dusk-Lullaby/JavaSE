package com.Sonnet.clazz.local;

public class LocalClass {

    public static void main(String[] args) {
        int result = calculate(1, 3);
        System.out.println(result);
    }

    public static int calculate(int a, int b) {

        // 局部内部类
        class Calculator {
            private int number1;
            private int number2;

            public Calculator(int number1, int number2) {
                this.number1 = number1;
                this.number2 = number2;
            }

            public int calculate() {
                return number1 + number2;
            }
        }

        Calculator calculator = new Calculator(a, b);

        return calculator.calculate();
    }

}

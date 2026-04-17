package com.lullaby._static;

public class CalculatorTest {

    public static void main(String[] args) {
//        Calculator calculator = new Calculator() {
//            @Override
//            public int calculator(int a, int b) {
//                return 0;
//            }
//        };

//        Calculator calculator = (a, b) -> MathUtil.minus(a, b);
        Calculator calculator = MathUtil::minus;
        int result = calculator.calculator(1, 10);
        System.out.println(result);

        Calculator calculator1 = MathUtil::add;
        int result1 = calculator1.calculator(1, 10);
        System.out.println(result1);

    }
}

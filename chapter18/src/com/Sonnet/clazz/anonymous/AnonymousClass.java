package com.Sonnet.clazz.anonymous;

public class AnonymousClass {

    public static void main(String[] args) {
        int result = calculate(10, 20);
        System.out.println(result);


        Animal dog = new Animal() {
            @Override
            public void eat() {
                System.out.println("勾勾吃石");
            }
        };
        dog.eat();
    }

    public static int calculate(int a, int b) {
//
//        class Calculator implements Calculate {
//
//            @Override
//            public int calculate(int a, int b) {
//                return a + b;
//            }
//        }
//
//        Calculate calculate = new Calculator();

//        Calculate calculator = new Calculate() {
//
//            @Override
//            public int calculate(int a, int b) {
//                return a + b;
//            }
//        };

        // 匿名内部类和构造方法很相似
        // 不同的地方在于：匿名内部类里面还有类的主体
        Calculate c = new Calculate() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        return c.calculate(a, b);
    }
}

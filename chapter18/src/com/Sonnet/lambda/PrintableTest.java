package com.Sonnet.lambda;

public class PrintableTest {

    public static void main(String[] args) {

        Printable p = new Printable() {
            @Override
            public void print(Object o) {
                System.out.println(o);
            }
        };
        p.print(1);

        // 函数式编程思想
        Printable p1 = o -> System.out.println(o);
        p1.print(2);
    }
}

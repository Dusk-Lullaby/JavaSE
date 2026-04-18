package com.lullaby.Predicate;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
//        Predicate<String> p1 = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("H");
//            }
//        };

        Predicate<String> p1 = str -> str.startsWith("H");
        System.out.println(p1.test("Hello"));
        System.out.println(p1.test("hello"));

        Predicate<String> p2 = str -> str.contains("Hello World");
        Predicate<String> p3 =  p1.negate();
        System.out.println(p3.test("Hello"));

        Predicate<String> p4 = p1.and(p2);
        System.out.println(p4.test("Hello World"));
        System.out.println(p4.test("Hello my World"));

        Predicate<String> p5 = p1.or(p2);
        System.out.println(p5.test("Hello my World"));
    }
}

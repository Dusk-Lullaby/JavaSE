package com.Sonnet.lambda;

public class AddTest {

    public static void main(String[] args) {

//        Add add = new Add() {
//            @Override
//            public int add(int a, int b) {
//                return 0;
//            }
//        };

        Add add = (a, b) -> a + b;

        System.out.println(add.add(1, 2));
    }
}

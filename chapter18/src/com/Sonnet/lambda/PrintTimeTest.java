package com.Sonnet.lambda;

public class PrintTimeTest {

    public static void main(String[] args) {

//        PrintTime time = new PrintTime() {
//            @Override
//            public void printTime() {
//                System.out.println(System.currentTimeMillis());
//            }
//        };

        PrintTime time1 = () -> System.out.println(System.currentTimeMillis());
        time1.printTime();
    }
}

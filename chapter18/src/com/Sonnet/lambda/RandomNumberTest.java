package com.Sonnet.lambda;

import java.util.Random;

public class RandomNumberTest {

    public static void main(String[] args) {

        Random random = new Random();

//        RandomNumber number = new RandomNumber() {
//            @Override
//            public int getRandomNumber(int start, int end) {
//                return (int) (Math.random() * (end - start) + start);
//            }
//        };

        RandomNumber number = (start, end) -> (int) (Math.random() * (end - start) + start);
        System.out.println(number.getRandomNumber(10, 29));


        Random random1 = new Random();
        int result = random1.nextInt(10) + 20;

        RandomNumber r = (start, end) -> new Random().nextInt(start) + end - start;
        System.out.println(r.getRandomNumber(10, 29));
    }
}

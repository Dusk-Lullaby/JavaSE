package com.lullaby.stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumberStream {

    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("1", "2", "3", "4");
        IntStream s2 = s1.mapToInt(Integer::parseInt);
        int[] arr = s2.toArray();
        System.out.println(Arrays.toString(arr));

        LongStream s3 = Stream.of("1", "2", "3", "4").mapToLong(Long::parseLong);
        long[] arr2 = s3.toArray();
        System.out.println(Arrays.toString(arr2));

        DoubleStream s4 = Stream.of("1", "2", "3", "4").mapToDouble(Double::parseDouble);
        double[] arr3 = s4.toArray();
        System.out.println(Arrays.toString(arr3));

        int[] intArr1 = {1, 2, 3, 4};
//        Integer[] intArr2 = Arrays.stream(intArr1).mapToObj(i -> i).toArray(Integer[]::new);
        Integer[] intArr2 = Arrays.stream(intArr1).boxed().toArray(Integer[]::new);

        Integer[] intArr3 = {1,2,3,4,5};
        int[] intArr4 = Arrays.stream(intArr3).mapToInt(Integer::intValue).toArray();
    }
}

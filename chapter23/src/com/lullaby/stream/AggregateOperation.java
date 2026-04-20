package com.lullaby.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregateOperation {

    public static void main(String[] args) {
//        List<Integer> numbers = List.of(30, 21, 58, 67, 90, 72);
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }

        Stream<Integer> s1 = Stream.of(30, 21, 58, 67, 90, 72);
//        s1.filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer % 2 == 0;
//            }
//        });
        Stream<Integer> s2 = s1.filter(number -> number % 2 == 0);
        // 将流中的元素收集为一个List集合,此时流就已经消亡了
        List<Integer> existNumbers = s2.collect(Collectors.toList());
        // 在使用流进行收集操作将报错
        Set<Integer> set = s2.collect(Collectors.toSet());
//        Integer[] arr = s2.toArray(new IntFunction<Integer[]>() {
//            @Override
//            public Integer[] apply(int value) {
//                return new Integer[value];
//            }
//        });
        // 在使用流进行收集操作将报错
        Integer[] arr = s2.toArray(Integer[]::new);
    }
}

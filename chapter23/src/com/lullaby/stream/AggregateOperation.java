package com.lullaby.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class AggregateOperation {

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("30", "21", "58", "67", "90", "72");
//        Stream<String> s = numbers.stream();
//        Optional<String> first = s.findFirst();
//        System.out.println(first.get());
//        Optional<String> optional = s.max(String::compareTo);
//        String max = optional.get();
//        System.out.println(max);
//        System.out.println(s.count());

        boolean exist1 = numbers.stream().map(Integer::parseInt).anyMatch(integer -> integer % 2 == 1);
        System.out.println(exist1);

        boolean exist2 = numbers.stream().map(Integer::parseInt).allMatch(integer -> integer % 2 == 1);
        System.out.println(exist2);

        boolean exist3 = numbers.stream().map(Integer::parseInt).noneMatch(integer -> integer % 2 == 1);
        System.out.println(exist3);
    }

    private static void operation() {
        //        List<Integer> numbers = List.of(30, 21, 58, 67, 90, 72);
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }

        Stream<Integer> s1 = Stream.of(30, 21, 58, 67, 90, 72, 58, 30, 80);
//        s1.filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer % 2 == 0;
//            }
//        });
//        Stream<String> s2 = s1.filter(number -> number % 2 == 0).distinct().skip(1).sorted().limit(2).map(new Function<Integer, String >() {
//            @Override
//            public String apply(Integer integer) {
//                return "字符串" + integer;
//            }
//        });
        Stream<String> s2 = s1.filter(number -> number % 2 == 0).distinct().skip(1).sorted().limit(2).map(integer -> "字符串" + integer);
        s2.forEach(System.out::println);
        // 将流中的元素收集为一个List集合,此时流就已经消亡了
//        List<Integer> existNumbers = s2.collect(Collectors.toList());
//        for (Integer number : existNumbers) {
//            System.out.println(number);
//        }
        // 在使用流进行收集操作将报错
//        Set<Integer> set = s2.collect(Collectors.toSet());
//        for (Integer number : set) {
//            System.out.println(number);
//        }
//        Integer[] arr = s2.toArray(new IntFunction<Integer[]>() {
//            @Override
//            public Integer[] apply(int value) {
//                return new Integer[value];
//            }
//        });
        // 在使用流进行收集操作将报错
//        Integer[] arr = s2.toArray(Integer[]::new);
//        for (Integer number : arr) {
//            System.out.println(number);
//        }
    }
}

package com.lullaby.consumer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("这是被消费的信息");

//        Consumer<String> consumer1 = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s.charAt(0));
//            }
//        };
        Consumer<String> consumer1 = s -> System.out.println(s.charAt(0));
        consumer1.accept("This is a consumer");

        Consumer<String> consumer2 = consumer.andThen(consumer1);
        consumer2.accept("先打印在取第一个字符");
        // 将数组转换为集合
        List<Integer> number = Arrays.asList(1,2,3,4,5);
//        number.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.print(integer);
//            }
//        });
//        number.forEach(integer -> System.out.print(integer));
        number.forEach(System.out::println);

        Set<String> names = new HashSet<>();
        names.add("admin");
        names.add("test");
        names.add("developer");
//        names.forEach(str -> System.out.println(str));
        names.forEach(System.out::println);
    }
}

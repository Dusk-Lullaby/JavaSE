package com.lullaby.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> s1 = number1.stream();

        Stream<Integer> s2 = Stream.of(6, 7, 8,9, 10);

        Stream<Integer> s3 = Stream.concat(s1, s2);

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        Stream<Map.Entry<String, Integer>> s4 = map.entrySet().stream();
    }
}

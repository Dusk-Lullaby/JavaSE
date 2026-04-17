package com.lullaby.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = (str, i) -> System.out.println(str + "->" + i);
        biConsumer.accept("a", 1);

        Map<String, String> counties = new HashMap<>();
        counties.put("CN", "中国");
        counties.put("US", "美国");
        counties.put("EN", "英国");
        counties.forEach((s1, s2) -> System.out.println(s1 + " -> " + s2));
    }
}

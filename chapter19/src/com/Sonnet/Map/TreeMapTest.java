package com.Sonnet.Map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
//        TreeMap<Computer, Integer> map = new TreeMap<>();
//        map.put(new Computer("联想", 3000), 1);
//        map.put(new Computer("外星人", 20000), 1);
//        for(Computer computer : map.keySet()) {
//            System.out.println(computer);
//        }

//        Comparator<Computer> comparator = new Comparator<Computer>() {
//            @Override
//            public int compare(Computer o1, Computer o2) {
//
//            }
//        };
//        Comparator<Computer> comparator = (Computer o1, Computer o2) -> {
//            return 0;
//        };
        Comparator<Computer> comparator = (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice());
        TreeMap<Computer, Integer> map1 = new TreeMap<>(comparator);
        map1.put(new Computer("联想", 3000), 1);
        map1.put(new Computer("外星人", 20000), 1);
        for(Computer computer : map1.keySet()) {
            System.out.println(computer);
        }

    }
}

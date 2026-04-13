package com.Sonnet.Set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("D");
        strings.add("C");
        strings.add("F");
        strings.add("A");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

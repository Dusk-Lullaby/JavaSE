package com.Sonnet.Example;

import java.nio.charset.Charset;

public class Example7 {

    public static void main(String[] args) {
        String s = "My God";

        char[] values = s.toCharArray();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        byte[] bytes1 = s.getBytes(Charset.forName("GB2312"));
        for(int i = 0; i < bytes1.length; i++) {
            System.out.println(bytes1[i]);
        }
    }
}

package com.Sonnet.Example;

public class Example17 {

    public static void main(String[] args) {
        String s = "ababababababababa";
        String target = "aba";
        int length = s.length();
        int targetLength = target.length();
        int cnt = 0;
        for (int i = 0; i <= length - targetLength; i++) {
            String s1 = s.substring(i, i + targetLength);
            if (s1.equals(target)) cnt++;
        }
        System.out.println(cnt);
    }
}

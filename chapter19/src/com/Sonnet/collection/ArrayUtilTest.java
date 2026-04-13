package com.Sonnet.collection;

public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtil util = new ArrayUtil();
        for (int i = 1; i <= 5; i++) {
            util.add(i);
        }
        for (int i = 0; i < util.getSize(); i++) {
            Object o = util.get(i);
            System.out.println(o);
        }
        System.out.println("==================");
        util.update(1, 14);
        for (int i = 0; i < util.getSize(); i++) {
            Object o = util.get(i);
            System.out.println(o);
        }
        System.out.println("======================");
        util.delete(4);
        for (int i = 0; i < util.getSize(); i++) {
            Object o = util.get(i);
            System.out.println(o);
        }
    }
}

package com.Sonnet.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListTest {
    public static void main(String[] args) {
        //集合有序是指存储顺序与遍历取出来的的顺序一致
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        //a a b c d -> a a b b c d -> a a n b c d
        list.add(2, "n");
        String old = list.set(1, "g");
        System.out.println(old);
        System.out.println("==================");
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("===================");
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            String s = iter.next();
            System.out.println(s);
        }
        System.out.println("====================");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String s = listIterator.next();
            System.out.println(s);
        }
        System.out.println("=====================");
        /*
            简单来说，原因在于：ListIterator 传入的索引代表的是“光标（Cursor）的位置”
            而不是直接指向“元素的下标”。

            光标索引:   0       1       2       3 (也就是 size)
            元素：          A       B       C
                        ^       ^       ^       ^
         */
        ListIterator<String> prevIterator = list.listIterator(list.size());
        while(prevIterator.hasPrevious()) {
            String s = prevIterator.previous();
            System.out.println(s);
        }
        System.out.println("=======================");
        List<String> subList = list.subList(2, 4);
        ListIterator<String> subIterator = subList.listIterator();
        //遍历1
        while(subIterator.hasNext()) {
            System.out.println(subIterator.next());
        }
        //遍历2
        for (String string : subList) {
            System.out.println(string);
        }
        System.out.println("=========================");

        int size = list.size();
        for(int i = 0; i < size; i ++) {
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("=============================");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        //移除下标为3这个位置的元素
        numbers.remove(3);
        //移除3这个元素
        numbers.remove((Integer) 3);
        for(Integer number : numbers) {
            System.out.println(number);
        }
        numbers.add(2);
        numbers.add(2);
        int index1 = numbers.indexOf(2);
        int index2 = numbers.lastIndexOf(2);
        System.out.println(index1);
        System.out.println(index2);
    }
}

package com.Sonnet.Queue;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

    public static void main(String[] args) {
        //构建队列时，通常都会给队列设置一个容量，因为默认容量太大了
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
//        String first = queue.element(); //获取队列中的第一个元素，如果队列为空，则抛出异常
//        System.out.println(first);
        String first = queue.peek();    //获取队列中的第一个元素，如果队列位空，则返回null
        System.out.println(first);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
//        queue.add("f"); //放入第六个元素将抛出异常
        boolean success = queue.offer("f");   //放入第六个元素不会抛出异常，只会返回false，表明返回失败
        System.out.println(success);

//        while (!queue.isEmpty()) {
//            String string = queue.poll();
//            System.out.println(string);
//        }

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println("=======================");
//        queue.remove(); //移除第六个元素将抛出异常
        String s = queue.poll();    //移除第六个元素不会抛出异常，但会返回null
        System.out.println(s);
    }

}

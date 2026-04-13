package com.Sonnet.Queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(4);
        queue.offer(5);
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        for(Integer number : queue) {
            System.out.println(number);
        }
        System.out.println("=================");
        while(!queue.isEmpty()) {
            Integer number = queue.poll();
            System.out.println(number);
        }

        PriorityQueue<User> userPriorityQueue = new PriorityQueue<>();
        userPriorityQueue.offer(new User("zhangsan", 0));
        userPriorityQueue.offer(new User("lisi", 1));
        userPriorityQueue.offer(new User("wangwu", 2));
        userPriorityQueue.offer(new User("ergou", 3));
        while(!userPriorityQueue.isEmpty()) {
            System.out.println(userPriorityQueue.poll());
        }
    }
}

package com.lullaby.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    static class SaleTask implements Runnable {

        private int totalTickets = 10;  // 售卖10张火车票

        private Lock lock = new ReentrantLock();    // 创建一个可重入锁

        // synchronized 作用在成员方法上，因此synchronized与成员有关
        @Override
        public void run() {
            while (true) {
                // 尝试获得锁
                if (lock.tryLock()) {
                    try {
                        if (totalTickets > 0) {
                            String name = Thread.currentThread().getName();
                            System.out.println(name + "火车票" + totalTickets);
                            totalTickets--;
                        }
                    } finally {
                        lock.unlock();  // 解锁
                    }
                }
                if (totalTickets <= 0) break;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        SaleTask task = new SaleTask(); // 一个成员
        Thread t1 = new Thread(task, "窗口1");    // 共用一个成员
        Thread t2 = new Thread(task, "窗口2");    // 共用一个成员
        Thread t3 = new Thread(task, "窗口3");    // 共用一个成员
        t1.start();
        t2.start();
        t3.start();
    }
}

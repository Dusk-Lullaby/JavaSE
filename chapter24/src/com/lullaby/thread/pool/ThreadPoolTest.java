package com.lullaby.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>(10);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,  // 核心线程数
                10, // 最大工作线程数
                2,  // 非核心线程的工作线程存活时间
                TimeUnit.SECONDS,   // 存活时间单位
                taskQueue,  // 任务队列
                Executors.defaultThreadFactory(),   // 线程池中的线程创建工厂
                new ThreadPoolExecutor.AbortPolicy());  // 拒绝新线程任务的策略

        for (int i = 0; i < 30; i++) {
            poolExecutor.submit(new ThreadTask(i));
            int corePoolSize = poolExecutor.getCorePoolSize();  // 获取核心线程数
            int size = poolExecutor.getQueue().size(); // 获取队列中任务个数
            long finish = poolExecutor.getCompletedTaskCount(); // 获取线程池执行完成任务的个数
            System.out.printf("线程池中核心线程数：%d, 队列中任务个数：%d，线程完成任务个数：%d\n", corePoolSize, size, finish);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        poolExecutor.shutdown();    // 关闭线程池，等待线程池中任务执行完成，但是不会接收新的任务
    }

    static class ThreadTask implements Runnable {

        private int number;

        public ThreadTask(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println("正在执行线程任务" + number);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

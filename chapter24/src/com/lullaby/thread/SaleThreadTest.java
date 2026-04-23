package com.lullaby.thread;

public class SaleThreadTest {

    static class SaleTask implements Runnable {

        private int totalTickets = 10;  // 售卖10长火车票

        @Override
        public void run() {
            while (true) {
                String name = Thread.currentThread().getName();
                System.out.println(name + "火车票" + totalTickets);
                totalTickets--;
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
        SaleTask task = new SaleTask();
        Thread t1 = new Thread(task, "窗口1");
        Thread t2 = new Thread(task, "窗口2");
        Thread t3 = new Thread(task, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

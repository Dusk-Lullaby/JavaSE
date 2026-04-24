package com.lullaby.thread.interact;

public class Account {

    private String name;

    private double balance;

    private boolean hasMoney = false;   // 存钱标志

    public Account(String name) {
        this.name = name;
    }

    public synchronized void store(double money) {
        if (hasMoney) { // 已经存钱
            System.out.println(name + "的爸爸等待通知存钱");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            balance += money;
            System.out.println(name + "爸爸存了" + money + "钱");
            hasMoney = true;
            notifyAll();    // 通知取钱
        }
    }

    public synchronized void draw(double money) {
        if (hasMoney) { // 已经存钱了
            if (balance < money) {
                System.out.println(name + "控诉没有钱");
                hasMoney = false;
                notify();   // 通知存钱
            } else {
                System.out.println(name + "取了" + balance + "钱");
                balance -= money;
            }
        } else {
            try {
                System.out.println(name + "等待爸爸存期");
                wait(); // 等待存期
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

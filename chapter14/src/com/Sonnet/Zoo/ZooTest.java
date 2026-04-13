package com.Sonnet.Zoo;

public class ZooTest {

    public static void main(String[] args) {
        Zookeeper zk = new Zookeeper();
        Animals a1 = new Lion();
        Animals a2 = new Tiger();

        zk.keep(a1);
        zk.keep(a2);

    }
}

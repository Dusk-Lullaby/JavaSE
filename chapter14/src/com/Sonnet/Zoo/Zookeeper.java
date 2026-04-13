package com.Sonnet.Zoo;

public class Zookeeper {

    public void keep(Animals animals) {
        animals.eat();
//        ((Lion)animals).strolling();

        //如果animals对象是一个Tiger类的实例对象
        if (animals instanceof Lion) {
            ((Lion) animals).strolling();
        } else if (animals instanceof Tiger) {
            System.out.println("老虎不能漫步");
        }
    }
}


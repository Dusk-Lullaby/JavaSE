package com.Sonnet.Zoo;

public class Lion extends Animals{

    @Override
    public void eat() {
        System.out.println("狮子在吃饭");
    }

    //子类特有的方法
    public void strolling() {
        System.out.println("狮子在漫步");
    }
}

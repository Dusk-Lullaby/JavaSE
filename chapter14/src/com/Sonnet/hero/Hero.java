package com.Sonnet.hero;

public abstract class Hero {

     String name;

    public Hero(String name) {
        this.name = name;
    }

    //抽象类
    public abstract  void attack();
}

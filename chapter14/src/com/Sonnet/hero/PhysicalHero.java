package com.Sonnet.hero;

public class PhysicalHero extends Hero{

    public PhysicalHero(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("物理攻击");
    }
}

package com.Sonnet.hero;

public class SpellHero extends Hero{
    @Override
    public void attack() {
        System.out.println("法术攻击");
    }

    public SpellHero(String name) {
        super(name);
    }
}

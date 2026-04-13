package com.Sonnet.hero;

public class HeroTest {

    public static void main(String[] args) {
        Hero hero1 = new PhysicalHero("李白");
        hero1.attack();
        Hero hero2 = new SpellHero("小乔");
        hero2.attack();
    }
}

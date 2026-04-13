package com.lullaby.pokemen.item.equipment;

import com.lullaby.pokemen.util.Tools;

/**
 * 手镯
 */
public class Bracelet extends Equipment {
    public Bracelet(String name, int levelNumber) {
        super(name, levelNumber);
        this.attack = Tools.getRandomNumber(20, 30, levelNumber);
        this.defense = Tools.getRandomNumber(20, 30, levelNumber);
        this.health = Tools.getRandomNumber(100, 200, levelNumber);
    }
}

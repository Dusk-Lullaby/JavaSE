package com.lullaby.pokemen.item.equipment;

import com.lullaby.pokemen.util.Tools;

/**
 * 铠甲
 */
public class Armor extends Equipment{

    public Armor(String name, int levelNumber) {
        super("铠甲", levelNumber);
        this.attack = 0;
        this.defense = Tools.getRandomNumber(40, 60, levelNumber);
        this.health = Tools.getRandomNumber(200, 250, levelNumber);
    }
}

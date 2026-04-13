package com.lullaby.pokemen.item.equipment;

import com.lullaby.pokemen.util.Tools;

/**
 * 项链
 */
public class Necklace extends Equipment{
    public Necklace(String name, int levelNumber) {
        super(name, levelNumber);
        this.attack = Tools.getRandomNumber(25, 35, levelNumber);
        this.defense = Tools.getRandomNumber(25, 25, levelNumber);
        this.health = Tools.getRandomNumber(120, 180, levelNumber);
    }
}

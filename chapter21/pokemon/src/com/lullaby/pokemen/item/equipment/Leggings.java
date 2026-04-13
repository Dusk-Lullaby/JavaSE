package com.lullaby.pokemen.item.equipment;

import com.lullaby.pokemen.util.Tools;

/**
 * 护腿
 */
public class Leggings extends Equipment{
    public Leggings(int levelNumber) {
        super("护腿", levelNumber);
        this.defense = Tools.getRandomNumber(30, 40, levelNumber);
        this.health = Tools.getRandomNumber(150, 200, levelNumber);
    }
}

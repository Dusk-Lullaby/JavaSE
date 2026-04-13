package com.lullaby.pokemen.item.equipment;

import com.lullaby.pokemen.util.Tools;

/**
 * 戒指
 */
public class Ring extends Equipment{
    public Ring(int levelNumber) {
        super("戒指", levelNumber);
        this.attack = Tools.getRandomNumber(20, 30, levelNumber);
        this.defense = Tools.getRandomNumber(20, 30, levelNumber);
        this.health = Tools.getRandomNumber(100, 200, levelNumber);
    }
}

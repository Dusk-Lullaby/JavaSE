package com.lullaby.pokemen.item.monster;

import com.lullaby.pokemen.item.Monster;
import com.lullaby.pokemen.util.Tools;

/**
 * 牛魔怪
 */
public class CattleMonster extends Monster {
    public CattleMonster(int levelNumber) {
        super("牛魔怪", levelNumber);
        this.attack = Tools.getRandomNumber(50, 60, levelNumber);
        this.defense = Tools.getRandomNumber(40, 50, levelNumber);
        this.health = Tools.getRandomNumber(700, 900, levelNumber);
        this.currentHealth = health;
    }
}

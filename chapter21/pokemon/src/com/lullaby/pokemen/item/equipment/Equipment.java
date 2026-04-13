package com.lullaby.pokemen.item.equipment;

import com.lullaby.pokemen.item.Item;

/**
 * 装备
 */
public abstract class Equipment extends Item {

    protected int attack;

    protected  int defense;

    protected int health;

    public Equipment(String name, int levelNumber) {
        super(name, levelNumber);
    }

    @Override
    public String getItemInformation() {
        return name + ": 攻击=" + attack + " 防御=" + defense + " 生命=" + health;
    }
}

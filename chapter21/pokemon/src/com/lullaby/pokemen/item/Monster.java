package com.lullaby.pokemen.item;

/**
 * 怪物
 */
public class Monster extends Item {
    public Monster(String name, int levelNumber) {
        super(name, levelNumber);
    }

    @Override
    public String getItemInformation() {
        return discovery ? name : "▧";
    }
}

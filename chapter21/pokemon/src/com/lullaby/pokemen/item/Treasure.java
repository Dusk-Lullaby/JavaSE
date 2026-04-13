package com.lullaby.pokemen.item;

/**
 * 宝箱
 */
public class Treasure extends Item {

    public Treasure(String name, int levelNumber) {
        super("宝箱", levelNumber);
    }

    @Override
    public String getItemInformation() {
        return discovery ? "⨀" : "▧";
    }
}

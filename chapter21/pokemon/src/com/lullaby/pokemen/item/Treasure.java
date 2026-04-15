package com.lullaby.pokemen.item;

import com.lullaby.pokemen.util.Tools;

/**
 * 宝箱
 */
public class Treasure extends Item {

    public Treasure(int levelNumber) {
        super("宝箱", levelNumber);
    }

    /**
     * 开启宝箱能够获得一个物品
     * @return 开启宝箱获得的物品
     */
    public Item open() {
        return Tools.getRandomItem(levelNumber);
    }

    @Override
    public String getItemInformation() {
        return discovery ? "¤" : "■";
    }
}

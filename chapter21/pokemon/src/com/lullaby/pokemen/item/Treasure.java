package com.lullaby.pokemen.item;

import com.lullaby.pokemen.util.Tools;

import java.util.Random;

/**
 * 宝箱
 */
public class Treasure extends Item {

    public Treasure(String name, int levelNumber) {
        super("宝箱", levelNumber);
    }

    /**
     * 开启宝箱能够获得一个物品
     * @return
     */
    public Item open() {
        Random random = new Random();
        // 取[0, 10)之间的随机数
        int num = Tools.getRandomNumber(10);
        if (num == 0) { // 获得宠物小精灵

        } else if (num <= 3) {  // 获得装备

        } else {    // 获得药品

        }

        return null;
    }

    @Override
    public String getItemInformation() {
        return discovery ? "⨀" : "▧";
    }
}

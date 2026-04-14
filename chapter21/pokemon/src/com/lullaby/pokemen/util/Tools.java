package com.lullaby.pokemen.util;

import com.lullaby.pokemen.item.HP;
import com.lullaby.pokemen.item.Item;
import com.lullaby.pokemen.item.equipment.*;
import com.lullaby.pokemen.item.pokemon.Bikachu;
import com.lullaby.pokemen.item.pokemon.Bulbasaur;
import com.lullaby.pokemen.item.pokemon.Charmander;
import com.lullaby.pokemen.item.pokemon.Jolteon;

import java.util.Random;

/**
 * 工具类
 */
public class Tools {

    /**
     * 随机数对象
     */
    private static final Random RANDOM = new Random();

    /**
     * 获取给定范围内的随机数
     * @param min 最小值
     * @param max 最大值
     * @param levelNumber 关卡编号
     * @return 随机数
     */
    public static int getRandomNumber(int min, int max, int levelNumber) {
        return RANDOM.nextInt(min, max) * levelNumber;
    }

    /**
     * 获取给定范围的随机数
     * @param min 最小值
     * @param max 最大值
     * @return 随机数
     */
    public static int getRandomNumber(int min, int max) {
        return getRandomNumber(min, max, 1);
    }

    /**
     * 获取给定范围的随机数
     * @param max 最大值
     * @return 随机数
     */
    public static int getRandomNumber(int max) {
        return getRandomNumber(0, max, 1);
    }

    /**
     * 获取随机物品
     * @param levelNumber 关卡编号
     * @return 获得的物品
     */
    public static Item getRandomItem(int levelNumber) {
        Random random = new Random();
        // 取[0, 10)之间的随机数
        int num = Tools.getRandomNumber(10);
        if (num == 0) { // 获得宠物小精灵，初级：中级：高级：究极 = 80:15:4:1
            int rate = Tools.getRandomNumber(100);
            if (rate == 0) {    // 究极小精灵
                return new Bikachu();
            }
            if (rate <= 4) {    // 高级
                return new Charmander();
            }
            if (rate <= 20) {   // 中级
                return new Jolteon();
            }
            return new Bulbasaur(); // 初级
        } else if (num <= 3) {  // 获得装备
            // 武器：项链：戒指：手镯：头盔：铠甲：护腿：鞋子 = 3：5：8：8：19：19：19：19
            int rate = Tools.getRandomNumber(100);
            if (rate < 3) { // 武器
                return new Weapon(levelNumber);
            }
            if (rate < 8) { // 项链
                return new Necklace(levelNumber);
            }
            if (rate < 16) {// 戒指
                return new Ring(levelNumber);
            }
            if (rate < 24) {// 手镯
                return new Bracelet(levelNumber);
            }
            if (rate < 43) {// 头盔
                return new Helmet(levelNumber);
            }
            if (rate < 62) {// 铠甲
                return new Armor(levelNumber);
            }
            if (rate < 81) {// 护腿
                return new Leggings(levelNumber);
            }
            else return new Shoe(levelNumber);  // 鞋子
        } else {    // 获得药品
            return new HP(levelNumber, 10);
        }
    }
}

package com.lullaby.pokemen.item;

import com.lullaby.pokemen.item.equipment.*;
import com.lullaby.pokemen.item.pokemon.Bikachu;
import com.lullaby.pokemen.item.pokemon.Bulbasaur;
import com.lullaby.pokemen.item.pokemon.Charmander;
import com.lullaby.pokemen.item.pokemon.Jolteon;
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
     * @return 开启宝箱获得的物品
     */
    public Item open() {
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

    @Override
    public String getItemInformation() {
        return discovery ? "⨀" : "▧";
    }
}

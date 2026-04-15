package com.lullaby.pokemen.level;

import com.lullaby.pokemen.DisplayItem;
import com.lullaby.pokemen.item.Portal;
import com.lullaby.pokemen.item.Treasure;
import com.lullaby.pokemen.item.monster.CattleMonster;
import com.lullaby.pokemen.item.monster.Mamoswine;
import com.lullaby.pokemen.item.monster.Moltres;
import com.lullaby.pokemen.item.monster.Ramoraid;
import com.lullaby.pokemen.util.Tools;

/**
 * 关卡地图
 */
public class LevelMap {
    /**
     * 关卡编号
     */
    private int number;
    /**
     * 地图上的物品：9 * 9
     */
    private static final DisplayItem[][] items = new DisplayItem[9][9];

    public LevelMap(int number) {
        this.number = number;
        generateMap();
    }

    /**
     * 生成地图---> 宝箱：怪物：传送门 = 39：39：1
     * 第一个位置和第二个位置不能使用
     */
    private void generateMap() {
        if (this.number == 1) { // 第一个关卡
            // 测试
            items[0][0] = new Mamoswine(number);
            // 第二个位置为初级怪物
            items[0][1] = new Mamoswine(number);
        } else {    // 其他关卡
            // 第一个位置为返回上一层关卡的传送门
            items[0][0] = new Portal(false);
            // 测试
            items[0][1] = new Portal(false);
        }
        // 记录生成的宝箱数量
        int generateTreasure = 0;
        // 记录生成的怪物数量
        int generateMonster1 = 0;       // 记录生成的初级怪物数量
        int generateMonster2 = 0;       // 记录生成的中级怪物数量
        int generateMonster3 = 0;       // 记录生成的高级怪物数量
        int generateMonster4 = 0;       // 记录生成的究级怪物数量
        int generateTotalMonster = 0;   // 记录生成的所有怪物数量
        // 记录生成的传送门数量
        int generatePortal = 0;
        while (generateTreasure < 39 || generateTotalMonster < 39 || generatePortal == 0 ) {
            // 获取随机坐标
            int index = Tools.getRandomNumber(2, 81);
            // 计算行列
            int row = index / items[0].length;
            int col = index % items[0].length;
            // 目标位置已经有物品存在
            if (items[row][col] != null) continue;
            // 获取一个随机数
            int rate = Tools.getRandomNumber(79);
            if (rate == 0) {    // 传送门
                // 传送门已经生成，直接跳过
                if (generatePortal == 1) continue;
                items[row][col] = new Portal(true);
                generatePortal++;
            } else if (rate < 40) { // 宝箱
                // 宝箱已经全部生成完毕，直接跳过
                if (generateTreasure == 39) continue;
                items[row][col] = new Treasure(number);
                generateTreasure++;
            } else {    // 怪物 初级：中级：高级：究极 = 18:12:6:3
                int num = Tools.getRandomNumber(39);
                if (num < 3) {  // 究极怪物
                    // 究极怪物已经全部生成，直接跳过
                    if (generateMonster4 == 3) continue;
                    items[row][col] = new Moltres(number);
                    generateMonster4++;
                } else if (num < 9) {   // 高级
                    // 高极怪物已经全部生成，直接跳过
                    if (generateMonster3 == 6) continue;
                    items[row][col] = new Ramoraid(number);
                    generateMonster3++;
                } else if (num < 21) {  // 中级
                    // 中极怪物已经全部生成，直接跳过
                    if (generateMonster2 == 12) continue;
                    items[row][col] = new CattleMonster(number);
                    generateMonster2++;
                } else {    // 初级
                    // 低极怪物已经全部生成，直接跳过
                    if (generateMonster1 == 18) continue;
                    items[row][col] = new Mamoswine(number);
                    generateMonster1++;
                }
                generateTotalMonster++;
            }
        }
    }

    /**
     * 展示地图
     */
    public void show() {
        for (int i = 0; i < items.length; i++) {
            String line1 = "";
            String line2 = "";
            for (int j = 0; j < items[0].length; j++) {
                // 第一行
                if (i == 0) {
                    if (j == 0) {   // 第一列
                        line1 += "┌───";
                        line2 += "│ " + items[i][j].getItemInformation() + " ";
                    } else if (j == items[0].length - 1) {  // 最后一列
                        line1 += "┬───┐";
                        line2 += "│ " + items[i][j].getItemInformation() + " │";
                    } else {
                        line1 += "┬───";
                        line2 += "│ " + items[i][j].getItemInformation() + " ";
                    }
                } else {
                    if (j == 0) {   //第一列
                        line1 += "├───";
                        line2 += "│ " + items[i][j].getItemInformation() + " ";
                    } else if (j == items[0].length - 1) {  // 最后一列
                        line1 += "┼───┤";
                        line2 += "│ " + items[i][j].getItemInformation() + " │";
                    } else {
                        line1 += "┼───";
                        line2 += "│ " + items[i][j].getItemInformation() + " ";
                    }
                }
            }
            System.out.println(line1);
            System.out.println(line2);
        }
        String lastLine = "";
        for (int i = 0; i < items[0].length; i++) {
            if (i == 0) {   // 第一列
                lastLine += "└───";
            } else if (i == items[0].length - 1) {  // 最后一列
                lastLine += "┴───┘";
            } else {
                lastLine += "┴───";
            }
        }
        System.out.println(lastLine);
    }
}

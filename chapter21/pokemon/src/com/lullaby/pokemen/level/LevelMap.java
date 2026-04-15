package com.lullaby.pokemen.level;

import com.lullaby.pokemen.DisplayItem;
import com.lullaby.pokemen.item.monster.Mamoswine;

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
     * 生成地图
     */
    private void generateMap() {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[0].length; j++) {
                items[i][j] = new Mamoswine(number);
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

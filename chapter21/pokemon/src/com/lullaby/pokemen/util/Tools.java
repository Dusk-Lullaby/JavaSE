package com.lullaby.pokemen.util;

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
}

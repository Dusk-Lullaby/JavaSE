package com.lullaby.pokemen.level;

/**
 * 关卡
 */
public class Level {
    /**
     * 关卡编号
     */
    private int number;
    /**
     * 关卡地图
     */
    private final LevelMap map;
    /**
     * 上一个关卡
     */
    private Level prevLevel;
    /**
     * 下一个关卡
     */
    private Level nextLevel;

    public Level( Level prevLevel, int number, Level nextLevel) {
        this.number = number;
        this.prevLevel = prevLevel;
        this.nextLevel = nextLevel;
        this.map = new LevelMap(number);
    }

    public int getNumber() {
        return number;
    }

    public Level getPrevLevel() {
        return prevLevel;
    }

    public Level getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }

    public LevelMap getMap() {
        return map;
    }
}

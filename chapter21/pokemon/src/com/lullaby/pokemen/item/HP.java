package com.lullaby.pokemen.item;

/**
 * 药品：回复血量
 */
public class HP extends Item{

    /**
     * 药品数量
     */
    private int count;

    public HP(int levelNumber, int count) {
        super("天山雪莲", levelNumber);
        this.count = count;
    }

    /**
     * 使用药品可以回复血量
     * @return 回复的血量
     */
    public int use() {
        count--;
        return levelNumber * 500;
    }

    /**
     * 检测药品是否可以被销毁
     * @return 是否可以销毁
     */
    public boolean canDestroy() {
        return count == 0;
    }

    public void addCount(int count) {
        this.count += count;
    }

    @Override
    public String getItemInformation() {
        return name;
    }

    public int getCount() {
        return count;
    }
}

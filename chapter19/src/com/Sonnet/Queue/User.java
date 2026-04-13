package com.Sonnet.Queue;

public class User implements Comparable<User>{

    private String name;

    private int level;

    public User() {
    }

    public User(String name, int level) {
        this.name = name;
        this.level = level;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return level
     */
    public int getLevel() {
        return level;
    }

    /**
     * 设置
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public String toString() {
        return "User{name = " + name + ", level = " + level + "}";
    }

    @Override
    public int compareTo(User o) {
        if (level == o.level) return 0;
        else if (level < o.level) return -1;
        else return 1;
    }
}

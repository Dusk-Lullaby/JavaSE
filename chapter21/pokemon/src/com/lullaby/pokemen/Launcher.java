package com.lullaby.pokemen;

import com.lullaby.pokemen.level.LevelMap;

/**
 * 启动类
 */
public class Launcher {

    public static void main(String[] args) {
        LevelMap map = new LevelMap(1);
        map.show();
    }
}

package com.Sonnet.File;

import java.io.File;

public class Example9 {
    public static void main(String[] args) {
        File folder = new File("D:\\Typora");
        recursiveFile(folder);

    }

    public static void recursiveFile(File folder) {
        //检测是否是文件夹
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    //是文件夹就调用方法
                    recursiveFile(file);
                }
            }
        //不是文件夹就打印文件的路径
        } else {
            System.out.println(folder.getPath());
        }
    }

}

package com.Sonnet.File;

import java.io.File;

/**
 * 使用递归打印文件夹下所有信息
 */
public class Example8 {
    public static void main(String[] args) {
        File folder = new File("D:\\Typora");
        recursiveFolder(folder);

    }

    //递归遍历文件夹
    public static void recursiveFolder(File folder) {
        //检测是否是文件夹
        if (!folder.isDirectory()) {
            System.out.println(folder.getPath());
            return;
        }

        File[] files = folder.listFiles();
        for (File file : files) {
            //如果不是文件夹就打印路径
            if (!file.isDirectory()) {
                System.out.println(file.getPath());
            //是文件夹就调用方法查看
            } else {
                recursiveFolder(new File(file.getPath()));
            }

        }
    }
}

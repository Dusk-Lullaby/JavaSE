package com.Sonnet.File;

import java.io.File;

public class Example10 {
    public static void main(String[] args) {
        deleteFolder(new File("chapter17\\Steps-test"));
    }

    public static void deleteFolder(File folder) {
        //检测是否是文件夹，是文件夹就进去看
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            //如果里面内容为空，就直接删除
            if (files == null) {
                folder.delete();
            //如果不为空，就调用方法
            } else {
                for (File file : files) {
                    deleteFolder(file);
                }
                //文件夹中文件删除完毕之后，文件夹也需要删除
                folder.delete();
            }
        //不是文件夹就删除
        } else {
            folder.delete();
        }
    }
}


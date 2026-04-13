package com.Sonnet.File;

import java.io.File;
import java.io.FileFilter;

public class Example4 {
    public static void main(String[] args) {


        File directory = new File("D:\\Typora\\develop\\java\\javaSE笔记");
        //列出文件夹中所有文件
        File[] files = directory.listFiles();
        if (files != null) {
//            for (int i = 0; i < files.length; i++) {
//                File file = files[i];
//            }
            //增强for循环
            for (File file : files) {
                System.out.println(file.getPath());
            }
        }

        File[] listFiles = directory.listFiles(new FileFilter() {
            //表示接收文件的条件
            @Override
            public boolean accept(File file) {
                //获取文件名，包含后缀
                String name = file.getName();
                //返回文件名.md结尾的文件
                return name.endsWith(".md");
            }
        });

        if (listFiles != null) {
            for (File file : listFiles) {
                System.out.println(file.getPath());
            }
        }

    }
}

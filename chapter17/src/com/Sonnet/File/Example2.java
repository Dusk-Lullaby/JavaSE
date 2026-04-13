package com.Sonnet.File;

import java.io.File;

public class Example2 {
    public static void main(String[] args) {
        File file = new File("D:\\idea_code\\develop\\code\\test\\javaSE-01\\chapter17\\File - test\\file - test.txt");
        //获取文件的绝对路径
        String absPath = file.getAbsolutePath();
        System.out.println(absPath);
        //获取文件的路径
        //可能是相对路径
        //也可能是绝对路径
        //根据构造方法的定位
        String path = file.getPath();
        System.out.println(path);
        //获取文件的大小,单位是字节
        long length = file.length();
        System.out.println(length);
        //获取文件的最后修改时间,单位毫秒
        long lastUpdateTime = file.lastModified();
        System.out.println(lastUpdateTime);

        System.out.println();
        //获取文件的名字
        System.out.println(file.getName());
        //获取文件的父级文件夹对象
        File parentFile = file.getParentFile();
        System.out.println(parentFile.getPath());
        System.out.println(parentFile.getName());
        //父级文件路径
        String parentPath = file.getParent();
        System.out.println(parentPath);



        System.out.println();
        //相对路径
        File file1 = new File("chapter17\\src\\FileExample.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.length());

        System.out.println();
        //父级
        File fileParent1 = file1.getParentFile();
        System.out.println(fileParent1.getPath());
        System.out.println(fileParent1.getName());


        // 添加检查
        if (file1.exists()) {
            System.out.println("文件存在");
            if (file1.isFile()) {
                System.out.println("是普通文件");
                System.out.println("文件大小: " + file1.length() + " 字节");
            } else {
                System.out.println("这不是文件，可能是目录");
            }
        } else {
            System.out.println("文件不存在！路径: " + file1.getAbsolutePath());
        }
    }
}

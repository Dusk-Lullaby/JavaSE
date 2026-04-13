package com.Sonnet.File;

import java.io.File;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) {
        File file1 = new File("chapter17\\File - test\\recode\\recode.txt");
        //判断是否可读
        boolean readable = file1.canRead();
        System.out.println("文件是否可读：" + readable);
        //判断是否可写
        boolean writable = file1.canWrite();
        System.out.println("文件是否可写：" + writable);
        //判断文件是否存在
        boolean exists = file1.exists();
        System.out.println("文件是否存在：" + exists);
        System.out.println("乱写的文件是否存在：" + new File("夹心饼干乱写的").exists());
        //判断文件是否是目录
        boolean isDirectory = file1.isDirectory();
        System.out.println("文件是否是目录:" + isDirectory);
        System.out.println("父级文件是否是目录：" + file1.getParentFile().isDirectory());
        //判断是否是一个正常文件
        boolean isFile = file1.isFile();
        System.out.println("文件是否是一个正常文件:" + isFile);
        //判断文件是否隐藏
        boolean isHidden = file1.isHidden();
        System.out.println("文件是否隐藏：" + isHidden);
        //判断文件是否可执行
        //可执行是指双击之后可执行
        boolean executable = file1.canExecute();
        System.out.println("判断文件是否可执行：" + executable);
        //判断是否创建文件
        File file2 = new File("chapter17\\File - test\\recode\\createNewFile.txt");
        if (!file2.exists()) {
            try {
                //创建文件时必须保证该文件的父级目录存在，否则报IO异常
                boolean success = file2.createNewFile();
                System.out.println("文件创建是否成功" + success);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //创建一级目录
        File file3 = new File("chapter17\\FileTest\\test.txt");
        File parentFile = file3.getParentFile();
        //通常会和创建目录的方法配合使用
        if (!parentFile.exists()) {
            //创建父级目录，但只能创建一级
            boolean creatMkdir = parentFile.mkdir();
            System.out.println("父级目录是否创建：" + creatMkdir);
        }
        if (!file3.exists()) {
            try {
                boolean creatSuccess = file3.createNewFile();
                System.out.println("文件是否创建成功：" + creatSuccess);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //创建多级目录
        File file4 = new File("chapter17\\Mkdir2\\Mkdir3\\Mkdir4\\test.txt");
        File parentFile4 = file4.getParentFile();
        if (!parentFile4.exists()) {
            boolean creatMkdir = parentFile4.mkdirs();
            System.out.println("多级目录是否创建：" + creatMkdir);
        }
        if (!file4.exists()) {
            try {
                boolean newFile = file4.createNewFile();
                System.out.println("文件是否创建" + newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //判断文件是否删除
        boolean deleteSuccess = file4.delete();
        System.out.println("文件是否删除:" + deleteSuccess);
        //删除文件夹时，必须保证问价夹中没有任何文件,也就是保证文件夹是空的
        boolean deleteFolders = file4.getParentFile().getParentFile().delete();
        System.out.println("文件夹是否删除：" + deleteFolders);

        //判断文件是否重命名
        File renameDest = new File("chapter17\\File - test\\recode——new\\recode.txt");
        //文件重命名是目标文件夹时，必须保证目标文件夹存在，重命名操作成功后，原来的文件就移动了
        boolean rename = file1.renameTo(renameDest);
        System.out.println("文件重命名是否成功：" + rename);

        //判断文件是否重命名
        File renameDest2 = new File("chapter17\\File - test\\recode\\夹心饼干.txt");
        //文件重命名是目标文件夹时，必须保证目标文件夹存在，重命名操作成功后，原来的文件就移动了
        boolean rename2 = file1.renameTo(renameDest2);
        System.out.println("文件重命名是否成功：" + rename2);
    }
}

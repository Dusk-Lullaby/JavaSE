package com.Sonnet.IOStream;

import java.io.*;

public class Example13 {
    public static void main(String[] args) {
        String path = "chapter17\\buffer\\buffer1.txt";
        String source = "chapter17\\buffer\\buffer1.txt";
        String dest = "chapter17\\buffer\\copy.txt";

        writerFile(path);
        readerFile(path);
        //文件拷贝
        copyFile(source, dest);

    }

    private static void readerFile(String path) {
        File file = new File(path);
        File parent = file.getParentFile();
        //如果父级文件不存在,创建多级目录
        if (!parent.exists()) {
            parent.mkdirs();
        }
        //创建一条文件输入通道
        try (Reader reader = new FileReader(file);
             //创建缓冲字符输入流
             BufferedReader bw = new BufferedReader(reader)) {
            char buf[] = new char[4096];
            while (true) {
                //读取一整行的内容，不包括换行字符
                //如果到达末端未读取任何字符返回null
                String line = bw.readLine();
                //读取到末尾
                if (line == null) break;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writerFile(String path) {
        File file = new File(path);
        //判断父级目录存不存在
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //因为Writer类实现了AutoCloseable接口，可以写在try（）{}cahtch{}的（）中
        //创建一条文件输出流
        try (Writer writer = new FileWriter(file);
             //创建缓冲字符输出流
             BufferedWriter bw = new BufferedWriter(writer);
             Reader reader = new FileReader(file)) {
            bw.write("这是第一行");
            //换行
            bw.newLine();
            bw.write("这是第二行");
            bw.newLine();
            bw.write("这是第三行");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFile(String source, String dest) {
        File sourceFile = new File(source);
        File destFile = new File(dest);
        //获取父级文件
        File parent = destFile.getParentFile();
        //如果父级文件不存在就创建多级目录
        if (!parent.exists()) parent.mkdirs();

        //创建通道
        try(Reader reader = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(reader);
            Writer writer = new FileWriter(destFile);
            BufferedWriter bw = new BufferedWriter(writer)) {
            //读取
            char[] buf = new char[4096];
            while (true) {
                //读取一整行
                String line = br.readLine();
                //读取到末尾
                if (line == null) break;
                //写入
                bw.write(line);
                //换行
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
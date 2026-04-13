package com.Sonnet.IOStream;

import java.io.*;

public class Example1 {
    public static void main(String[] args) {
        try {
            File dir = new File("chapter17\\IO_Test");
            //如果文件夹不存在就构建多级目录
            if (!dir.exists()) dir.mkdirs();
            //将内容写入文件时，需保证这个文件的父级目录一定存在，否则会报文件未找到异常
            File file = new File("chapter17\\IO_Test\\io.txt");
            //构建磁盘文件与内存的通道
            //true 是追加，false是覆盖，默认为覆盖
            OutputStream os = new FileOutputStream(file, true);
            String text = "夹心饼干真好吃";
            byte[] bytes1 = text.getBytes();
            byte[] bytes2 = "嫁衣".getBytes();
            //一次向通道写一个字节至文件中
            for (byte b : bytes1) {
                os.write(b);
            }
            //向通道中一次将所有字节数组中的内容全部输出过去
            os.write(bytes2);
            //使用偏移量和长度的时候需要考虑数组下标越界
            os.write(bytes1, 3, bytes1.length - 4);
            //在通道关闭之前使用，强制将通道中的数据输出到文件中
            os.flush();
            //关闭通道
            os.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

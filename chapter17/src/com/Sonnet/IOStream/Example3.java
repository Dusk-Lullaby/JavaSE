package com.Sonnet.IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Example3 {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("chapter17\\IO_Test\\io.txt");
            //构建了一个长度为31的字节数组
            //实际开发中字节数组一般定义为1024的整数倍
            byte[] buffer = new byte[31];
            while (true) {
                //从通道中读取数据存入字节数组buffer中，返回值就是读取的字节长度
                int len = is.read(buffer);
                //如果读取到数据的末尾则返回-1
                if (len == -1) break;
                System.out.println(len);
                System.out.println(new String(buffer));
            }
            is.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

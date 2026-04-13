package com.Sonnet.IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Example2 {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("chapter17\\IO_Test\\io.txt");
            //获取通道中的数据长度
            int length = is.available();
            //根据通道中数据的长度，构建字节数组，但需要考虑到一点，如果通道中数据长度过长，那么字节数组构建太大，则可能导致内存不够，比如使用流读取一个大小为10G的文件
            byte[] buffer = new byte[length];
            byte[] buffer1 = new byte[length];
            int index = 0;
            //读取通道中的数据，一次读取一个字节。如果读取到末尾，则返回-1
            while (true) {
                byte b = (byte)is.read();
                if (b == -1) break;
                buffer[index++] = b;
            }
            System.out.println(new String(buffer));

            InputStream is2 = new FileInputStream("chapter17\\IO_Test\\io.txt");
            //将通道中的数据全部读取到buffer1数组中
            int readCount = is2.read(buffer1);
            System.out.println("读取了" + readCount + "个字节");
            System.out.println(new String(buffer1));
            //关闭通道
            is.close();
            is2.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

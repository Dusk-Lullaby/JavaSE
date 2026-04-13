package com.Sonnet.IOStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Example8 {
    public static void main(String[] args) {
        //必须要保证文件夹存在
        File file = new File("chapter17\\IO_Test\\writer.txt");
        File parentfile = file.getParentFile();
        //文件夹不存在就创建多级目录
        if (!parentfile.exists()) {
            parentfile.mkdirs();
        }
        //Writer类实现了AutoCloseable接口，因此可以将Writer类对象的构建方法放在try后面的()中
        try(Writer writer = new FileWriter("chapter17\\IO_Test\\writer.txt", true)) {
            String text = "夹心饼干超好吃";
            char[] values = text.toCharArray();
            for (char c : values) {
                writer.write(c);
            }
            writer.write(values, 0, 4);
            //强制将通道中的数据写入文件
            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

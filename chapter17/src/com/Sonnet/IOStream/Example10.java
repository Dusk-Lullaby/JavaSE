package com.Sonnet.IOStream;

import java.io.*;

public class Example10 {
    public static void main(String[] args) {
        String resource = "chapter17\\IO_Test\\writer.txt";
        String dest = "chapter17\\IO_Test\\char_copy_test.txt";
        charCopy(resource, dest);
    }

    public static void charCopy(String resource, String dest) {
        File resourcefile = new File(resource);
        File destfile = new File(dest);
        File parentfile = destfile.getParentFile();
        //如果文件夹不存在就创建
        if (!parentfile.exists()) {
            parentfile.mkdirs();
        }

        try(Reader reader = new FileReader(resourcefile);
            Writer writer = new FileWriter(destfile)) {
            char[] buffer = new char[4096];
            while (true) {
                int len = reader.read(buffer);
                if (len == -1) break;
                writer.write(buffer, 0 , len);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.Sonnet.IOStream;

import java.io.*;

public class Example12 {
    public static void main(String[] args) {
        String resource = "chapter17\\IO_Test\\io.txt";
        String dest = "chapter17\\IO_Test\\char_buffer.txt";
        bufferedSteam(resource, dest);
    }

    public static void bufferedSteam(String resource, String dest) {
        File file = new File(dest);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }

        try(Reader reader = new FileReader(resource);
            BufferedReader br = new BufferedReader(reader);
            Writer writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer)) {
            char[] buffer = new char[4096];
            while (true) {
                int len = br.read(buffer);
                if (len == -1) break;
                bw.write(buffer, 0 , len);
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

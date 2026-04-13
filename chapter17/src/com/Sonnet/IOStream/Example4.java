package com.Sonnet.IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Example4 {
    public static void main(String[] args){
        try {
            InputStream is = new FileInputStream("chapter17\\IO_Test\\io.txt");
            byte[] buffer = new byte[30];
            while (true) {
                int len = is.read(buffer);
                if (len == -1) break;
                System.out.println(new String(buffer));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.Sonnet.IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Example5 {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("chapter17\\IO_Test\\io.txt");
            byte[] buffer = new byte[1024];
            int offset = 0;
            while (true) {
                int len = is.read(buffer, offset, 40 );
                if (len == -1) break;
                System.out.println(len);
                offset += len;
            }
            System.out.println(new String(buffer, 0, offset));
            is.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

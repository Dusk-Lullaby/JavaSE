package com.Sonnet.IOStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Example9 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("chapter17\\IO_Test\\writer.txt")) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int c = reader.read();
                if (c == -1) break;
                sb.append((char)c);
                //不强转打印的是数字
                System.out.print((char)c);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (Reader reader = new FileReader("chapter17\\IO_Test\\io.txt")) {
            char[] buffer = new char[4096];
            int offset = 0;
            while (true) {
                int len = reader.read(buffer, offset, 30);
                if (len == -1) break;
                offset += len;
            }
            System.out.println(new String(buffer, 0, offset));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

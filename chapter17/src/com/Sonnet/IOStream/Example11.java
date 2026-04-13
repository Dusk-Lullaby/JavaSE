package com.Sonnet.IOStream;

import java.io.*;

public class Example11 {
    public static void main(String[] args) {
        File file = new File("chapter17\\IO_Test\\buffer_test");
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try(InputStream is = new FileInputStream("chapter17\\IO_Test\\io.txt");
            BufferedInputStream bis = new BufferedInputStream(is);
            OutputStream os = new FileOutputStream("chapter17\\IO_Test\\buffer_test");
            BufferedOutputStream bos = new BufferedOutputStream(os)) {
            byte[] buffer = new byte[4096];
            while (true) {
                int len = bis.read(buffer);
                if (len == -1) break;
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

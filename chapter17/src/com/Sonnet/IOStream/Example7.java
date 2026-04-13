package com.Sonnet.IOStream;

import java.io.*;

public class Example7 {
    public static void main(String[] args) {
        String sourceFile = "chapter17\\IO_Test\\io.txt";
        String destFile = "chapter17\\IO_Test\\IO_OutputStream.txt";
        new File("chapter17\\IO_Test\\IO_OutputStream.txt").delete();
        copyFile1(sourceFile, destFile);
    }

    /**
     * 文件拷贝
     *
     * @param sourceFile
     * @param destFile
     */
    public static void copyFile1(String sourceFile, String destFile) {
        File file = new File(destFile);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(sourceFile);
            os = new FileOutputStream(destFile);
            byte[] buffer = new byte[4096];
            while (true) {
                int len = is.read(buffer);
                if (len == -1) break;
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            close(is, os);
        }
    }

        public static void copyFile2 (String sourceFile, String destFile) {
            File file = new File(destFile);
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            //jdk1.7之后可以使用
            //try(){}catch{}语句,使用该语句无需管理流的close，可以节省许多代码
            //写在括号中的代码只能够是实现了AutoCloseable接口的类
            //InputSteam和OutputSteam继承了Closeable接口
            //Closeable继承了AutoCloseable接口
            try (InputStream is = new FileInputStream(sourceFile);
                 OutputStream os = new FileOutputStream(destFile)) {
                byte[] buffer = new byte[4096];
                while (true) {
                    int len = is.read(buffer);
                    if (len == -1) break;
                    os.write(buffer, 0, len);
                }
                os.flush();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    //不定长自变量,本质是一个数组，在使用不定长自变量作为方法时，该方法必须为该方法的最后一个参数
    public static void close (Closeable...closeables){
        for (Closeable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

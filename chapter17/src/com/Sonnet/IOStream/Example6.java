package com.Sonnet.IOStream;

import java.io.*;

public class Example6 {
    public static String address = "chapter17\\IO_Test\\";
    public static File addresFile = new File(address);

    public static void main(String[] args) {
        String sourceFile = address + "io.txt";
        String destFile = address + "IO_OutputStream.txt";
        copyFile(sourceFile, destFile);
    }

    private static void copyFile(String sourceFile, String destFile) {
        try {
            InputStream is = new FileInputStream(sourceFile);
            OutputStream os = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int length = is.read(buffer);
                if (length == -1) {
                    break;
                }
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void StepsFile(String sourceFile, String destFile) {
        //判断原文件是不是目录，是目录就创建目录
        File sourcefile = new File(sourceFile);
        File destfile = new File(destFile);
        if (sourcefile.isDirectory()) {
            destfile.mkdirs();
            File[] childsourecesFile = sourcefile.listFiles();
            //如果子文件不为空，就递归
            if (childsourecesFile != null) {
                for (File childsourceFile : childsourecesFile) {
                    StepsFile(childsourceFile.getPath(), "");
                }
            }
        //如果不是目录，就copy内容
        } else {

        }

    }
}

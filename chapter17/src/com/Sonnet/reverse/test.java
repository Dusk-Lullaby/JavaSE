package com.Sonnet.reverse;

import java.io.*;

public class test {
    public static void main(String[] args) {
        String path = "chapter17\\reverse\\test.txt";
        write(path);
        read(path);
    }

    private static void write(String path) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (!parent.exists()) parent.mkdirs();
        try(OutputStream os = new FileOutputStream(file);
            OutputStreamWriter ops = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(ops);) {
            String[] lines = {
                    "jiaxin",
                    "binggan",
                    "zhenhaochi"
            };
            for (String s : lines) {
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void read(String path) {
        try(InputStream is = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

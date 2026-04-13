package com.Sonnet.Object;

import java.io.*;

public class test {
    public static void main(String[] args) {
        String path = "chapter17\\object\\test.txt";
        write(path);
        read(path);
    }

    private static void read(String path) {
        try(//创建一条文件输入通道
            InputStream is = new FileInputStream(path);
            //创建一条对象输入通道
            ObjectInputStream ois = new ObjectInputStream(is);) {
            //注意强转
            Student s = (Student) ois.readObject();
            System.out.println(s);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(String path) {
        File file = new File(path);
        File parent = file.getParentFile();
        //父类文件不存在，就创建父级目录
        if (!parent.exists()) parent.mkdirs();
        try(//创建一条文件输出流
            OutputStream os = new FileOutputStream(file);
            //创建一条对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(os);) {
            oos.writeObject(new Student("zhangsan", 18));
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

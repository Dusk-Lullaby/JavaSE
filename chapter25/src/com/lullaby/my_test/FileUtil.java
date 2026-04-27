package com.lullaby.my_test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static <T> List<T> readData(String path) {
        File file = new File(path);
        List<T> listData = new ArrayList<>();
        if (file.exists() && file.length() > 0) {
            try (InputStream inputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);){
                listData = (List<T>) objectInputStream.readObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return listData;
    }

    public static <T> void writeData(String path, List<T> dataList) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (!parent.exists())
            parent.mkdirs();
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);){
            objectOutputStream.writeObject(dataList);
            objectOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

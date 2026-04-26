package com.lullaby.user;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static <T> List<T> readData(String path) {
        List<T> dataList = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            try (InputStream inputStream = new FileInputStream(path);
                 ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);){
                dataList = (List<T>) objectInputStream.readObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return dataList;
    }

    public static <T> void writeData(String path, List<T> dataList) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }
        try (OutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);){
            objectOutputStream.writeObject(dataList);
            objectOutputStream.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

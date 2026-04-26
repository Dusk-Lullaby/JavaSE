package com.lullaby.user;

import java.io.*;
import java.net.Socket;

public class MessageUtil {

    public static <T> void sendMessage(Socket socket, Message<T> message) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
        socket.shutdownOutput();
    }

    public static <T> Message<T> receiveMessage(Socket socket) throws IOException, ClassNotFoundException {
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
       return (Message<T>) objectInputStream.readObject();
    }
}

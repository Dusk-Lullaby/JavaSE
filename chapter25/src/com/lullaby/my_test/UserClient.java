package com.lullaby.my_test;

import java.io.IOException;
import java.net.Socket;

public class UserClient {

    private Socket socket;

    public UserClient(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
    }

    public void sendMessage(Message<User> user) throws IOException {
        MessageUtil.sendMessage(socket, user);
    }

    public String receiverMessage() throws IOException, ClassNotFoundException {
        Message<String> back = MessageUtil.receiveMessage(socket);
        return back.getData();
    }

    public static void main(String[] args) {
        try {
            UserClient userClient = new UserClient("localhost", 6666);
            User user = new User("李四", "Hello Server, I'm Client");
            userClient.sendMessage(new Message<>(user, "register"));
//            userClient.sendMessage(new Message<>(user, "login"));
            System.out.println(userClient.receiverMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

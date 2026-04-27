package com.lullaby.my_test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class UserServer {

    private ServerSocket serverSocket;

    private static final String USER_PATH = "chapter25/src/com/lullaby/my_test/user.obj";

    public UserServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Message<User> userMessage = MessageUtil.receiveMessage(socket);
                String action = userMessage.getAction();
                if (action.equals("register")) {
                    List<User> userList = FileUtil.readData(USER_PATH);
                    User user = userMessage.getData();
                    boolean exists = userList.stream().anyMatch(user::equals);
                    Message<String> message;
                    if (exists) {
                        message = new Message<>("注册失败", "back");
                    } else {
                        userList.add(user);
                        FileUtil.writeData(USER_PATH, userList);
                        message = new Message<>("注册成功", "back");
                    }
                    MessageUtil.sendMessage(socket, message);
                } else if (action.equals("login")) {
                    List<User> userList = FileUtil.readData(USER_PATH);
                    User user = userMessage.getData();
                    boolean exists = userList.stream().anyMatch(user::equals);
                    if (exists) {
                        MessageUtil.sendMessage(socket, new Message<>("登录成功", "back"));
                    } else {
                        MessageUtil.sendMessage(socket, new Message<>("账户或者密码错误", "back"));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UserServer userServer = new UserServer(6666);
            userServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.lullaby.user;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class UserServer {

    private static final String USER_PATH = "chapter25/src/com/lullaby/user/user.obj";
    
    private ServerSocket serverSocket;

    public UserServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        while (true) {
            try {
                Socket userClient = serverSocket.accept();
                Message<User> message = MessageUtil.receiveMessage(userClient);
                String action = message.getAction();
                if ("register".equals(action)) {
                    register(message, userClient);
                } else if ("login".equals(action)) {
                    login(message, userClient);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void login(Message<User> message, Socket userClient) throws IOException {
        // 读取存档的用户列表
        List<User> users = FileUtil.readData(USER_PATH);
        // 获取登录的用户信息
        User loginUser = message.getData();
        // 检测用户列表中是否存在登录的用户信息
        boolean exists = users.stream().anyMatch(loginUser::equals);
        String msg = exists ? "登录成功" : "账号或密码错误";
        Message<String> backMsg = new Message<>("back", msg);
        MessageUtil.sendMessage(userClient, backMsg);
    }

    private static void register(Message<User> message, Socket userClient) throws IOException {
        // 读取存档的用户列表
        List<User> users = FileUtil.readData(USER_PATH);
        // 获取注册的用户信息
        User registerUser = message.getData();
        // 检测用户列表中是否存在注册的用户信息
        boolean exists = users.stream().anyMatch(registerUser::equals);
        Message<String> backMessage;
        if (exists) {
            backMessage = new Message<>("back", "账号已被注册");
            MessageUtil.sendMessage(userClient, backMessage);
        } else {
            // 将用户信息添加至用户列表中
            users.add(registerUser);
            String info;
            try {
                // 将用户列表重新存档
                FileUtil.writeData(USER_PATH, users);
                info = "注册成功";
            } catch(RuntimeException e) {
                info = "注册失败";
            }
            backMessage = new Message<>("back", info);
            MessageUtil.sendMessage(userClient, backMessage);
        }
    }

    public static void main(String[] args) {
        try {
            UserServer userServer = new UserServer(8888);
            userServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

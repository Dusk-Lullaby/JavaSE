package com.lullaby.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private ServerSocket server;

    public TcpServer(int port) throws IOException {
        this.server = new ServerSocket(port);
    }

    /**
     * 服务器启动
     */
    public void start() {
        // 服务器不能挂，因此使用死循环
        while (true) {
            try {
                // 等待客户端连接程序，程序会被阻塞，与Scanner的next（）一样
                Socket connectionClient = server.accept();
                String msg = SocketUtil.receiveMsg(connectionClient);
                System.out.println(msg);
                SocketUtil.sendMsg(connectionClient, "Hello Client, I'm Server");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        try {
            TcpServer serve = new TcpServer(6666);
            serve.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

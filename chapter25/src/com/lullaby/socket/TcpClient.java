package com.lullaby.socket;

import java.io.IOException;
import java.net.Socket;

public class TcpClient {

    private Socket client;  // 客户端套接字

    public TcpClient(String ip, int port) throws IOException {
        this.client = new Socket(ip, port);
    }

    /**
     * 客户端发送信息
     * @param msg 信息
     */
    public void sendMsg(String msg) throws IOException {
        SocketUtil.sendMsg(client, msg);
    }

    public String receiveMsg() throws IOException {
        return SocketUtil.receiveMsg(client);
    }

    public static void main(String[] args) {
        try {
            TcpClient client = new TcpClient("localhost", 6666);
            client.sendMsg("Hello Server, I'm Client");
            System.out.println(client.receiveMsg());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

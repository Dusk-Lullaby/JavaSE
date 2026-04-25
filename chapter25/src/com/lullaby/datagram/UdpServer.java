package com.lullaby.datagram;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {

    private DatagramSocket server;

    public UdpServer(int port) throws SocketException {
        server = new DatagramSocket(port);
    }

    /**
     * 服务器启动
     */
    public void start() {
        while (true) {
            String msg = DatagramUtil.receive(server);
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        UdpServer server = null;
        try {
            server = new UdpServer(6666);
            server.start();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}

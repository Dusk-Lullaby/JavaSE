package com.lullaby.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
            DatagramPacket packet = DatagramUtil.receive(server);
            int length = packet.getLength();
            String msg = new String(packet.getData(), 0, length);
            System.out.println(msg);
            InetAddress address = packet.getAddress();
            String ip = address.getHostAddress();
            int port = packet.getPort();
            try {
                DatagramUtil.sendPacket(server, "Hello Client, I'm Server", ip, port);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

package com.lullaby.datagram;

import java.io.IOException;
import java.net.*;

public class UdpClient {

    private DatagramSocket client;

    public UdpClient() throws SocketException {
        client = new DatagramSocket();  // 绑定任意端口
    }

    public void sendPacket(String msg, String ip, int port) throws IOException {
        byte[] data = msg.getBytes();
        InetAddress address = InetAddress.getByName(ip);
        // 创建了一个发送数据的数据包
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, port);
        client.send(packet);
    }

    public static void main(String[] args) {
        try {
            UdpClient client = new UdpClient();
            client.sendPacket("Hello Server, I'm Client", "localhost", 6666);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

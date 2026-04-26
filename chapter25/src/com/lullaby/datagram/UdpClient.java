package com.lullaby.datagram;

import java.io.IOException;
import java.net.*;

public class UdpClient {

    private DatagramSocket client;

    public UdpClient() throws SocketException {
        client = new DatagramSocket();  // 绑定任意端口
    }

    public void sendPacket(String msg, String ip, int port) throws IOException {
        DatagramUtil.sendPacket(client, msg, ip, port);
    }

    public String receivePacket() {
        DatagramPacket packet = DatagramUtil.receive(client);
        int length = packet.getLength();
        String msg = new String(packet.getData(), 0, length);
        return msg;
    }

    public static void main(String[] args) {
        try {
            UdpClient client = new UdpClient();
            client.sendPacket("Hello Server, I'm Client", "localhost", 6666);
            System.out.println(client.receivePacket());
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

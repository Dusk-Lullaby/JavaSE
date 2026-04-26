package com.lullaby.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramUtil {

    private static final int BUFFER_SIZE = 8192;

    /**
     * 发送数据报
     * @param socket 数据报套接字
     * @param msg 发送的消息
     * @param ip 发送消息的目标计算机ip
     * @param port 发送消息的目标计算机端口
     * @throws IOException
     */
    public static void sendPacket(DatagramSocket socket, String msg, String ip, int port) throws IOException {
        byte[] data = msg.getBytes();
        InetAddress address = InetAddress.getByName(ip);
        // 创建了一个发送数据的数据包
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, address, port);
        socket.send(packet);
    }

    /**
     * 接收数据报
     * @param socket 数据报套接字
     * @return
     */
    public static  DatagramPacket receive(DatagramSocket socket) {
        String msg = null;
        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return packet;
    }
}

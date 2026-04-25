package com.lullaby.socket;

import java.io.*;
import java.net.Socket;

/**
 * Socket套接字相关功能封装
 * 信息接收和信息发送
 */
public class SocketUtil {

    /**
     * 接收套接字信息
     * @param socket 套接字
     * @return 信息
     * @throws IOException
     */
    public static String receiveMsg(Socket socket) throws IOException {
        // 服务器读取客户端传输的信息
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        // 标识输入通道中的数据已经被读取完毕，如果再读取则直接读取到-1，表示读取结束
        socket.shutdownInput();
        return stringBuilder.toString();
    }

    public static void sendMsg(Socket socket, String msg) throws IOException {
        // 获取客户端输出通道
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(msg);
        bufferedWriter.flush();
        // 客户端已经输出完成，如果在向通道中写数据将会报IOException
        socket.shutdownOutput();
    }
}

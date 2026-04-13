package com.Sonnet.IOStream;

import java.io.*;

public class Example14 {
    public static void main(String[] args) {
        String path = "chapter17\\data\\data.txt";
        dataWrite(path);
        dataRead(path);
    }

    private static void dataRead(String path) {
        File file = new File(path);
        //创建一条文件输入通道
        try(InputStream is = new FileInputStream(file);
            //创建二进制数据输入流
            DataInputStream dis = new DataInputStream(is)) {
            //读取， 要按写入的顺序读取, 不然会报EOFException异常
            boolean b = dis.readBoolean();
            System.out.println(b);
            byte by = dis.readByte();
            System.out.println(by);
            Short s = dis.readShort();
            System.out.println(s);
            char c = dis.readChar();
            System.out.println(c);
            int i = dis.readInt();
            System.out.println(i);
            float f = dis.readFloat();
            System.out.println(f);
            double d = dis.readDouble();
            System.out.println(d);
            long l = dis.readLong();
            System.out.println(l);
            String str = dis.readUTF();
            System.out.println(str);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
            //要先捕捉EOFException（EndOfFile）
            //EOFException继承了IOException，先子类后父类
        } catch (EOFException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dataWrite(String path) {
        File file  = new File(path);
        File parent = file.getParentFile();
        //父级文件不存在, 创建多级目录
        if (!parent.exists()) parent.mkdirs();
        //创建一体条文件输出流
        try (OutputStream os = new FileOutputStream(file);
            //创建二进制数据输出流
             DataOutputStream dos = new DataOutputStream(os) ){
            dos.writeBoolean(true);
            dos.writeByte(-1);
            dos.writeShort(-2);
            dos.writeChar('a');
            dos.writeInt(-3);
            dos.writeFloat(4.0f);
            dos.writeDouble(100.0);
            dos.writeLong(400L);
            dos.writeUTF("夹心饼干");
            dos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

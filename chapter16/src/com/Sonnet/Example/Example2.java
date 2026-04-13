package com.Sonnet.Example;

//public class Example2 {
//
//    public static void main(String[] args) {
//        //这里会创建2个对象
//        //一个是字面量会在方法区中的常量池中创建一个对象
//        //另一个是new String（“ ”）构造方法创建出来的对象
//        String s1 = new String("超用心在线教育");
//        System.out.println(s1);
//    }
//}

import java.nio.charset.Charset;

public class Example2 {
    public static void main(String[] args) {

        char[] values = {'a', 'b', 'c', 'd'};
        String s2 = new String(values);
        System.out.println(s2);

        //offset: 偏移
        //在使用这种构造方法时，一定要考虑数组下标越界的问题
        String s3 = new String(values, 1, 3);
        System.out.println(s3);

        //字节可以存储整数，字符也可以使用整数描述，这个整数就是ASCII码的整数值
        byte[] bytes = {97, 98, 99, 100, 101, 102};
        String s4 = new String(bytes);
        System.out.println(s4);

        String s5 = new String(bytes, 2, 3);
        System.out.println(s5);

        //构建UTF-8字符集
        Charset charset = Charset.forName("UTF-8");
        String s6 = new String(bytes, charset);
        System.out.println(s6);

    }
}
package com.Sonnet.Example;

public class Example12 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("夹心饼干");
        sb.append("夹心饼干");
        sb.append(1);
        sb.append(1.0);
        sb.append(true);
        sb.append('a');
        System.out.println(sb);


        StringBuffer buffer = new StringBuffer(1024);
        buffer.append("夹心饼干");
        buffer.append("夹心饼干");//synchronized同步锁
        buffer.append(1);
        buffer.append(1.0);
        buffer.append(true);
        buffer.append('a');
        System.out.println(buffer);

        sb.append(buffer);
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder();
        sb1.append("夹心饼干").append(1).append('a').append(true);
        System.out.println(sb1);
    }
}

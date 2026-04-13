package com.Sonnet.p1;

public class Test {
    public static void main(String[] args) {
        //变量f的类型是father
        father f = new child();
        //f 调用show方法时， 不会调用father定义的方法
        f.show();
    }
}

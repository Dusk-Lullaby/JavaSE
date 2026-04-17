package com.lullaby.functional;

public class HelloTest {

    public static void main(String[] args) {

//        Hello hello = name -> System.out.println(name);
        Hello hello = System.out::println;
        hello.sayHello("蔡徐坤");
    }
}

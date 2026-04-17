package com.lullaby.functional;

@FunctionalInterface
public interface Hello {

    void sayHello(String name);

    static void show(){};

    default void print(){};

    private void test() {};
}

package com.lullaby.member;

public class ComputerTest {

    public static void main(String[] args) {
        Computer computer = new Computer(new Printer());
        computer.print("This is method reference");
    }
}

package com.Sonnet.electrical_appliances;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.check(new AirConditioner());
        p.check(new Fan());
        p.check(new TV());
    }
}

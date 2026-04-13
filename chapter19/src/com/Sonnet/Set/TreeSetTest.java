package com.Sonnet.Set;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Car> cars = new TreeSet<>();
        cars.add(new Car("奥迪", 100000));
        cars.add(new Car("保时捷", 150000));
        cars.add(new Car("大众", 50000));
        for(Car car : cars) {
            System.out.println(car);
        }
    }
}

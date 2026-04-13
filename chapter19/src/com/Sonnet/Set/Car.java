package com.Sonnet.Set;

public class Car implements Comparable<Car> {
    private String brand;

    private double price;

    public Car() {
    }

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Car{brand = " + brand + ", price = " + price + "}";
    }

    @Override
    public int compareTo(Car o) {
        return Double.compare(o.price, price);
    }
}

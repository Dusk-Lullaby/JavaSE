package com.Sonnet.Map;

public class Computer /*implements Comparable<Computer>*/{

    private  String brand;

    private double price;

    public Computer() {
    }

    public Computer(String brand, double price) {
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
        return "Computer{brand = " + brand + ", price = " + price + "}";
    }

//    @Override
//    public int compareTo(Computer o) {
//        return Double.compare(price, o.price);
//    }
}

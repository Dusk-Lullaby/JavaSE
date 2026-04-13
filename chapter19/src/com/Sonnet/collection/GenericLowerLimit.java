package com.Sonnet.collection;

public class GenericLowerLimit {

    public static void main(String[] args) {
        // 集合种存储的元素类型可以是Number的子类、Number类、Number的父类
        MyCollection<? super Number> c = new MyCollection<>();
        // 虽然存储元素的类型可以是Number的父类，但是由于父类类型无法确定具体有多少种
        // 因此在使用添加功能的时，编译器会报错
//        c.add(new Object());
        // 但是集合种可以存储Number类
        c.add(1.0);
    }
}

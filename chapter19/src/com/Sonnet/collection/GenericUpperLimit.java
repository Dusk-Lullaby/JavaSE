package com.Sonnet.collection;

public class GenericUpperLimit {
    public static void main(String[] args) {
        //定义了一个泛型上限为Number的集合 Integer Double Short Byte Float Long
        MyCollection<? extends Number> c = new MyCollection<>();
        //添加元素时，使用的是？extends Number 来对泛型变量进行替换
        //当传入参数时，无法确定参数应该怎么来匹配 ？extends Number
        //因此不能存储数据
//        c.add((Integer)1);
//        c.add(1.0);
    }

}

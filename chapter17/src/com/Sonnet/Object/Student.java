package com.Sonnet.Object;

import java.io.Serializable;

//实现Serializable接口，实现序列化
public class Student implements Serializable {
    public String name;
    public int age;

    public Student() {};

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

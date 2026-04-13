package com.Sonnet.Compare;

import java.util.*;

public class CompareTest {
    public static void main(String[] args) {
        Student[] students = {
                new Student("zhangsan", 20),
                new Student("lisi", 21),
                new Student("wangwu", 23),
                new Student("ergou", 28)
        };
        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("=================");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("zhangsan", 20));
        studentList.add(new Student("lisi", 21));
        studentList.add(new Student("wangwu", 23));
        studentList.add(new Student("ergou", 28));
        //对集合排序
        Collections.sort(studentList);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}

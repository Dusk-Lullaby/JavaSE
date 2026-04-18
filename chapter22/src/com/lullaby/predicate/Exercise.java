package com.lullaby.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Exercise {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("张三", "男", 20),
                new Student("李四", "女", 21),
                new Student("王五", "男", 22),
                new Student("二狗", "女", 23),
                new Student("一狗", "男", 24),
                new Student("二狗", "女", 18),
                new Student("三狗", "男", 16),
                new Student("四狗", "女", 19),
                new Student("五狗", "男", 23),
                new Student("六狗", "女", 10)
        );

        Predicate<Student> p1 = student -> student.getSex().equals("男");
        Predicate<Student> p2 = student -> student.getAge() > 20;
        Predicate<Student> p3 = p1.and(p2);
        list.forEach(student -> {
            if (p3.test(student)) {
                System.out.println(student);
            }
        });
    }
}

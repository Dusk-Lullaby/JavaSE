package com.lullaby.function;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Exercise {

    private static class Student {

        private String name;

        private String sex;

        private int age;


        public Student() {
        }

        public Student(String name, String sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        /**
         * 获取
         * @return name
         */
        public String getName() {
            return name;
        }

        /**
         * 设置
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取
         * @return sex
         */
        public String getSex() {
            return sex;
        }

        /**
         * 设置
         * @param sex
         */
        public void setSex(String sex) {
            this.sex = sex;
        }

        /**
         * 获取
         * @return age
         */
        public int getAge() {
            return age;
        }

        /**
         * 设置
         * @param age
         */
        public void setAge(int age) {
            this.age = age;
        }

        public String toString() {
            return "Student{name = " + name + ", sex = " + sex + ", age = " + age + "}";
        }
    }

    public static void main(String[] args) {
        String path = "chapter22\\src\\com\\lullaby\\function\\stu";
        Function<String, Student> function = str -> {
            String[] strings = str.split("，");
            Function<String, Integer> stringIntegerFunction = Integer::parseInt;
            return new Student(strings[0], strings[1], stringIntegerFunction.apply(strings[2]));
        };

        List<Student> students = readStudent(path, function);
        students.forEach(System.out::println);
    }

    public static List<Student> readStudent(String path, Function<String, Student> function) {
        List<Student> students = new ArrayList<>();
        try (FileReader reader = new FileReader(path);
             BufferedReader bf = new BufferedReader(reader)){
            String line;
            while ((line = bf.readLine()) != null) {
                students.add(function.apply(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}

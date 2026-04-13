package com.Sonnet.List;

public class Student {

    private String name;
    private String male;
    private int age;
    private double grade;


    public Student() {
    }

    public Student(String name, String male, int age, double grade) {
        this.name = name;
        this.male = male;
        this.age = age;
        this.grade = grade;
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
     * @return male
     */
    public String getMale() {
        return male;
    }

    /**
     * 设置
     * @param male
     */
    public void setMale(String male) {
        this.male = male;
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

    /**
     * 获取
     * @return grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * 设置
     * @param grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String toString() {
        return name + "," + male + "," + age + "," + grade;
    }
}

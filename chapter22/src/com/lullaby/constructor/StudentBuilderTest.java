package com.lullaby.constructor;

public class StudentBuilderTest {

    public static void main(String[] args) {
//        StudentBuilder studentBuilder = new StudentBuilder() {
//            @Override
//            public Student build(String name, String sex) {
//                return new Student(name, sex);
//            }
//        };

//        StudentBuilder studentBuilder = (name, sex) -> new Student(name, sex);

        StudentBuilder studentBuilder = Student::new;
        Student student = studentBuilder.build("张山", "男");
        System.out.println(student);
    }
}

package com.Sonnet.List;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 从控制台录入5位学生信息：姓名，性别，年龄，成绩，
 * 并将这些学生信息以“，”衔接起来，
 * 然后存储至文本中。
 * 然后再从文本将这些信息读取至集合中。
 */
public class Exercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            System.out.println("请输入姓名：");
            student.setName(scanner.next());
            System.out.println("请输入性别：");
            student.setMale(scanner.next());
            System.out.println("请输入年龄：");
            student.setAge(scanner.nextInt());
            System.out.println("请输入成绩：");
            student.setGrade(scanner.nextDouble());
            studentList.add(student);
        }
        String path = "D:\\idea_code\\develop\\code\\test\\javaSE-01\\chapter19\\Exercise\\exercise.txt";
        saveStudents(studentList, path);
        System.out.println(readStudents(path));
    }

    public static List<Student> readStudents(String path) {
        List<Student> list = new ArrayList<>();
        File file = new File(path);
        File parent = file.getParentFile();
        if (!parent.exists()) parent.mkdirs();
        try(Reader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                Student student = new Student();
                String[] arr = line.split(",");
                student.setName(arr[0]);
                student.setMale(arr[1]);
                student.setAge(Integer.parseInt(arr[2]));
                student.setGrade(Double.parseDouble(arr[3]));
                list.add(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void saveStudents(List<Student> studentList, String path) {

        File file = new File(path);
        File parent = file.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
        }

        try (Writer writer = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);){
              for(Student student: studentList) {
                  bufferedWriter.write(student.toString());
                  bufferedWriter.newLine();
              }
              bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

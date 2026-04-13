package com.Sonnet.Compare;

import java.util.*;

public class ComparatorTest {

    public static void main(String[] args) {
        Course[] courses = {
                new Course("java", 5),
                new Course("html", 3),
                new Course("javascript", 2),
                new Course("jdbc", 6),
        };
//        Comparator<Course> comparator = new Comparator<Course>() {
//            @Override
//            public int compare(Course o1, Course o2) {
//                return 0;
//            }
//        };
        Comparator<Course> c = (o1, o2) -> {
            int score1 = o1.getScore();
            int score2 = o2.getScore();
            if (score1 == score2) return o1.getName().compareTo(o2.getName());
            else if (score1 < score2) return 1;
            else return -1;
        };
        Arrays.sort(courses, c);
        for (Course course : courses) {
            System.out.println(course);
        }
        System.out.println("===================");
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("java", 5));
        courseList.add(new Course("html", 3));
        courseList.add(new Course("javascript", 2));
        courseList.add(new Course("jdbc", 6));
        Collections.sort(courseList, c);
        for (Course course : courseList) {
            System.out.println(course);
        }
    }
}

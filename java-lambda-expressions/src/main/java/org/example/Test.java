package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Bao", 20, 6.5);
        Student s2 = new Student("Duy", 18, 9);
        Student s3 = new Student("Huy", 25, 7.1);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        students.forEach((s) -> System.out.println(s));

        for(int i = 0; i < students.size(); i++) {
            for(int j = i + 1; j < students.size(); j++) {
                if(students.get(i).compareTo(students.get(j)) > 0) {
                }
            }
        }

        System.out.println("----------------");
        Collections.sort(students);
        System.out.println("----------------");
        students.forEach((s) -> System.out.println(s));

    }

}


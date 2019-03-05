package com.greenfoxacademy.cohort.models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private static int numberOfStudents = 0;
    private int id;
    private String name;
    private String gender;
    private int age;
    private List<Exam> exams;

    public Student(String name, String gender, int age, Exam... exams) {
        this.id = this.numberOfStudents;
        this.numberOfStudents++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.exams = new ArrayList<>();
        for (Exam exam : exams) {
            this.exams.add(exam);
        }
    }

    public Student() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public List<Exam> getExams() {
        return exams;
    }
}

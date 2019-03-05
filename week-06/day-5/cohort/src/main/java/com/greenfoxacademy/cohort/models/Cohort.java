package com.greenfoxacademy.cohort.models;

import java.util.ArrayList;
import java.util.List;

public class Cohort {
    private static int numberOfCohorts = 0;
    private int id;
    private String name;
    private String startedAt;
    private List<Student> students;

    public Cohort(String name, String startedAt, List<Student> students) {
        this.id = numberOfCohorts;
        this.numberOfCohorts++;
        this.name = name;
        this.startedAt = startedAt;
        this.students = students;
    }

    public Cohort(String name, String startedAt) {
        this.id = numberOfCohorts;
        this.numberOfCohorts++;
        this.name = name;
        this.startedAt = startedAt;
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        this.students.add(student);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public List<Student> getStudents() {
        return students;
    }
}

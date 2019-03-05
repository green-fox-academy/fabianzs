package com.greenfoxacademy.cohort.models;

public class Exam {
    private String type;
    private int score;

    public Exam(String type, int score) {
        this.type = type;
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public int getScore() {
        return score;
    }
}

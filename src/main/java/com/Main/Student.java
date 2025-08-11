package com.Main;

import java.util.ArrayList;

public class Student {
    private String name;
    private String id;
    private int age;
    private ArrayList<Integer> grades;

    public Student(String name, String id, int age, ArrayList<Integer> grades) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grades: " + grades + ", Average: " + String.format("%.2f", calculateAverage());
    }
}


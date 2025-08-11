package com.Main;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Find a student by their ID
    public Student findStudentById(String id) {
        for (Student student : students) {

            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    // Remove a student from the list using their ID
    public boolean removeStudent(String id) {
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student); // Remove the student object
            return true;
        }
        return false;
    }

    // Edit the details of a student
    public boolean editStudent(String id, String newName, int newAge, ArrayList<Integer> newGrades) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setName(newName); // Update name
            student.setAge(newAge);   // Update age
            student.setGrades(newGrades); // Update grades
            return true;
        }
        return false;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

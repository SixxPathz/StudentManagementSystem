package com.Main;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // StudentManager instance
        StudentManager manager = new StudentManager();
        // Scanner for reading input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        // Main loop for the menu system
        while (running) {
            // Display menu options
            System.out.println("--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine(); // Read user choice
            switch (choice) {
                case "1":
                    // Add a new student
                    addStudent(manager, scanner);
                    break;
                case "2":
                    // Edit an existing student
                    editStudent(manager, scanner);
                    break;
                case "3":
                    // Remove a student by ID
                    removeStudent(manager, scanner);
                    break;
                case "4":
                    // Show all students
                    manager.displayStudents();
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addStudent(StudentManager manager, Scanner scanner) {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter grades (comma separated): ");
            String gradesInput = scanner.nextLine();
            ArrayList<Integer> grades = new ArrayList<>();
            for (String gradeStr : gradesInput.split(",")) {
                int grade = Integer.parseInt(gradeStr.trim());
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100.");
                    return;
                }
                grades.add(grade);
            }
            Student student = new Student(name, id, age, grades);
            manager.addStudent(student);
            System.out.println("Student added successfully!\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers for age and grades.\n");
        }
    }

    private static void editStudent(StudentManager manager, Scanner scanner) {
        System.out.print("Enter ID of student to edit: ");
        String id = scanner.nextLine();
        Student student = manager.findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.\n");
            return;
        }
        try {
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new age: ");
            int newAge = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new grades (comma separated): ");
            String gradesInput = scanner.nextLine();
            ArrayList<Integer> newGrades = new ArrayList<>();
            for (String gradeStr : gradesInput.split(",")) {
                int grade = Integer.parseInt(gradeStr.trim());
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100.");
                    return;
                }
                newGrades.add(grade);
            }
            boolean success = manager.editStudent(id, newName, newAge, newGrades);
            if (success) {
                System.out.println("Student updated successfully!\n");
            } else {
                System.out.println("Failed to update student.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers for age and grades.\n");
        }
    }

    private static void removeStudent(StudentManager manager, Scanner scanner) {
        System.out.print("Enter ID of student to remove: ");
        String id = scanner.nextLine();
        boolean success = manager.removeStudent(id);
        if (success) {
            System.out.println("Student removed successfully!\n");
        } else {
            System.out.println("Student not found.\n");
        }
    }
}
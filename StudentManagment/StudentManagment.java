// Name: BADAL PRASAD           
// Course: B.Tech CSE(Full Stack Development)
// Roll Number: 2501351020

import java.util.InputMismatchException;
import java.util.Scanner;

// CUSTOM EXCEPTION
class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

//STUDENT CLASS
class Student {
    private int rollNumber;
    private String studentName;
    private Integer[] marks = new Integer[3];

    public Student(int rollNumber, String studentName, Integer[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Validate marks using custom exception
    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == null) {
                throw new InvalidMarksException("Marks for subject " + (i + 1) + " cannot be null");
            }
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i + 1) + ": " + marks[i]);
            }
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return sum / 3.0;
    }

    public void displayResult() {
        System.out.println("----- Student Result -----");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + studentName);

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Marks in Subject " + (i + 1) + ": " + marks[i]);
        }

        double avg = calculateAverage();
        System.out.println("Average: " + avg);

        if (avg >= 33)
            System.out.println("Result: Pass");
        else
            System.out.println("Result: Fail");

        System.out.println("--------------------------");
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

// Main class
public class StudentManagment {

    Student[] students = new Student[100];
    int count = 0;
    Scanner sc = new Scanner(System.in);

    // Add Student
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            Integer[] marks = new Integer[3];

            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
            }

            Student s = new Student(roll, name, marks);

            // Validate marks (may throw custom exception)
            s.validateMarks();

            students[count++] = s;
            System.out.println("Student added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter numbers only.");
            sc.nextLine(); // clear buffer

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }

        finally {
            System.out.println("Returning to main menu...");
        }
    }

    // Show Student Details
    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = sc.nextInt();

            for (int i = 0; i < count; i++) {
                if (students[i].getRollNumber() == roll) {
                    students[i].displayResult();
                    return;
                }
            }

            System.out.println("Student not found!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid roll number.");
            sc.nextLine();
        }

        finally {
            System.out.println("Returning to main menu...");
        }
    }

    // Main Menu
    public void mainMenu() {
        while (true) {
            System.out.println("\n===== Student Result Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: showStudentDetails(); break;
                    case 3:
                        System.out.println("Exiting... Thank you!");
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        StudentManagment s = new StudentManagment();
        s.mainMenu();
    }
}
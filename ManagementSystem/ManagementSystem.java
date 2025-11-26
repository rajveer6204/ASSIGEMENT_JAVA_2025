// Name: BADAL PRASAD           
// Course: B.Tech CSE(Full Stack Development)
// Roll Number: 2501351020

import java.util.*;
class Employee {
    protected int employeeId;
    protected String name;
    protected double salary;

    // Overloaded constructors
    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    // Calculate bonus (Base - 5% bonus)
    public double calculateBonus() {
        return salary * 0.05;
    }

    // Display details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
    }
}

class Manager extends Employee {
    private String department;

    // Manager constructor using super
    public Manager(int employeeId, String name, double salary, String department) {
        super(employeeId, name, salary);
        this.department = department;
    }

    // Overriding bonus (Managers get 10%)
    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // show common details
        System.out.println("Department: " + department);
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int employeeId, String name, double salary, String programmingLanguage) {
        super(employeeId, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding bonus (Developers get 7%)
    @Override
    public double calculateBonus() {
        return salary * 0.07;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

//main class
public class ManagementSystem {

    Employee[] employees = new Employee[100];  // polymorphic array
    int count = 0;
    Scanner sc = new Scanner(System.in);

    // Add Manager
    public void addManager() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        employees[count++] = new Manager(id, name, salary, dept);
        System.out.println("Manager added successfully!");
    }

    // Add Developer
    public void addDeveloper() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Programming Language: ");
        String lang = sc.nextLine();

        employees[count++] = new Developer(id, name, salary, lang);
        System.out.println("Developer added successfully!");
    }

    // Display specific employee
    public void displayEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                employees[i].displayDetails();
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Display all employees
    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees added yet!");
            return;
        }

        for (int i = 0; i < count; i++) {
            employees[i].displayDetails();
            System.out.println("------------------------");
        }
    }

    // Main Menu
    public void menu() {
        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. Display Employee Details");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addManager(); break;
                case 2: addDeveloper(); break;
                case 3: displayEmployee(); break;
                case 4: displayAllEmployees(); break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        ManagementSystem ms = new ManagementSystem();
        ms.menu();
    }
}
import java.util.*;

public class CalculatorApp {

    // Calculator Methods (Method Overloading)
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c) { return a + b + c; }
    public int subtract(int a, int b) { return a - b; }
    public double multiply(double a, double b) { return a * b; }
    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Error: Cannot divide by zero!");
        return (double) a / b;
    }

    // ----- User Interface Methods -----
    Scanner sc = new Scanner(System.in);
    CalculatorApp calc = this;

    void performAddition() {
        System.out.println("\n1. Add two integers\n2. Add two doubles\n3. Add three integers");
        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                System.out.print("Enter two integers: ");
                System.out.println("Result: " + calc.add(sc.nextInt(), sc.nextInt()));
                break;
            case 2:
                System.out.print("Enter two doubles: ");
                System.out.println("Result: " + calc.add(sc.nextDouble(), sc.nextDouble()));
                break;
            case 3:
                System.out.print("Enter three integers: ");
                System.out.println("Result: " + calc.add(sc.nextInt(), sc.nextInt(), sc.nextInt()));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    void performSubtraction() {
        System.out.print("Enter two integers: ");
        System.out.println("Result: " + calc.subtract(sc.nextInt(), sc.nextInt()));
    }

    void performMultiplication() {
        System.out.print("Enter two doubles: ");
        System.out.println("Result: " + calc.multiply(sc.nextDouble(), sc.nextDouble()));
    }

    void performDivision() {
        System.out.print("Enter two integers: ");
        try {
            System.out.println("Result: " + calc.divide(sc.nextInt(), sc.nextInt()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ----- Main Menu -----
    void mainMenu() {
        int ch;
        do {
            System.out.println("\n===== Calculator Application =====");
            System.out.println("1. Add Numbers\n2. Subtract Numbers\n3. Multiply Numbers\n4. Divide Numbers\n5. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1: performAddition(); break;
                case 2: performSubtraction(); break;
                case 3: performMultiplication(); break;
                case 4: performDivision(); break;
                case 5: System.out.println("Exiting... Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (ch != 5);
    }

    public static void main(String[] args) {
        new CalculatorApp().mainMenu();
    }
}

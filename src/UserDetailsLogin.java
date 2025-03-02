import java.util.Scanner;

public class UserDetailsLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();


        String studentID;
        while (true) {
            System.out.print("Enter your Student ID (numbers only): ");
            studentID = scanner.nextLine().trim();

            if (studentID.matches("\\d+")) {
                break;
            } else {
                System.out.println("Invalid Student ID! Please enter numbers only.");
            }
        }

        // Login system
        int choice;
        while (true) {
            System.out.println("\nSelect Login Type:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice == 1 || choice == 2) {
                    break;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input. Please enter 1 or 2.");
        }

        if (choice == 1) {
            // Admin Login
            while (true) {
                String enteredStudentID;
                while (true) {
                    System.out.print("Enter your Student ID (Last 3 digits will be used, numbers only): ");
                    enteredStudentID = scanner.nextLine().trim();

                    if (enteredStudentID.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Invalid Student ID! Please enter numbers only.");
                    }
                }

                String lastThreeDigits = enteredStudentID.length() >= 3 ? enteredStudentID.substring(enteredStudentID.length() - 3) : "000";

                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (username.equals("Admin" + lastThreeDigits) && password.equals("Password" + lastThreeDigits)) {
                    System.out.println("Admin login successful!");
                    break;
                } else {
                    System.out.println("Login failed! Wrong username or password. Try again.");
                }
            }
        } else {
            // Student Login
            while (true) {
                System.out.print("Enter your Name: ");
                String studentName = scanner.nextLine();

                String enteredStudentID;
                while (true) {
                    System.out.print("Enter your Student ID (numbers only): ");
                    enteredStudentID = scanner.nextLine().trim();

                    if (enteredStudentID.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Invalid Student ID! Please enter numbers only.");
                    }
                }

                if (studentName.equalsIgnoreCase(name) && enteredStudentID.equals(studentID)) {
                    System.out.println("Student Login Successful!");
                    System.out.println("Name: " + studentName);
                    System.out.println("Student ID: " + enteredStudentID);
                    break;
                } else {
                    System.out.println("Login Failed! Wrong name or student ID. Try again.");
                }
            }
        }

        scanner.close();
    }
}

import java.util.Scanner;
import java.util.Calendar;

public class UserDetailsLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect user details
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Student ID: "); // Tambahkan input Student ID di awal
        String studentID = scanner.nextLine().trim(); // Simpan Student ID sejak awal

        System.out.print("Enter your gender (M/F): ");
        char genderChar = scanner.next().charAt(0);
        scanner.nextLine(); // Consume newline
        String gender = (genderChar == 'M' || genderChar == 'm') ? "Male" :
                (genderChar == 'F' || genderChar == 'f') ? "Female" : "Unknown";

        System.out.print("Enter your year of birth: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid year.");
            scanner.next(); // Consume invalid input
        }
        int yearOfBirth = scanner.nextInt();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - yearOfBirth;
        scanner.nextLine(); // Consume newline

        System.out.println("\nUser Details:");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);

        // Login system
        System.out.println("\nSelect Login Type:");
        System.out.println("1. Admin");
        System.out.println("2. Student");
        System.out.print("Enter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter 1 or 2.");
            scanner.next(); // Consume invalid input
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            // Admin Login
            System.out.print("Enter your Student ID (Last 3 digits will be used): ");
            String enteredStudentID = scanner.nextLine().trim();
            String lastThreeDigits = enteredStudentID.length() >= 3 ? enteredStudentID.substring(enteredStudentID.length() - 3) : "000";

            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (username.equals("Admin" + lastThreeDigits) && password.equals("Password" + lastThreeDigits)) {
                System.out.println("Admin login successful!");
            } else {
                System.out.println("Login failed! Wrong username or password.");
            }
        } else if (choice == 2) {
            // Student Login
            System.out.print("Enter your Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter your Student ID: ");
            String enteredStudentID = scanner.nextLine().trim();

            if (studentName.equalsIgnoreCase(name) && enteredStudentID.equals(studentID)) {
                System.out.println("Student Login Successful!");
                System.out.println("Name: " + studentName);
                System.out.println("Student ID: " + enteredStudentID);
            } else {
                System.out.println("Login Failed! Wrong name or student ID.");
            }
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}

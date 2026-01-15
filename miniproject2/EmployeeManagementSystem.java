package miniproject2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class EmployeeManagementSystem {

    static final String FILE_NAME = "employees.dat";
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> empList = new ArrayList<>();

    public static void main(String[] args) {

        // LOGIN SYSTEM
        if (!login()) {
            System.out.println("Invalid Login! Exiting...");
            return;
        }

        loadFromFile();

        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> displayEmployees();
                    case 3 -> searchEmployee();
                    case 4 -> updateSalary();
                    case 5 -> deleteEmployee();
                    case 6 -> sortEmployees();
                    case 7 -> displayDepartments();
                    case 8 -> {
                        saveToFile();
                        System.out.println("Thank You!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Choice!");
                }
            } catch (ValidationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static boolean login() {
        String USERNAME = "admin";
        String PASSWORD = "admin123";

        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        return u.equals(USERNAME) && p.equals(PASSWORD);
    }

    static void addEmployee() throws ValidationException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : empList)
            if (e.getId() == id)
                throw new ValidationException("Employee ID must be unique!");

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        if (salary <= 0)
            throw new ValidationException("Salary must be positive!");

        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        if (dept.isEmpty())
            throw new ValidationException("Department cannot be empty!");

        empList.add(new Employee(id, name, salary, dept));
        saveToFile();
        System.out.println("Employee Added Successfully");
    }

    static void displayEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No Employees Found");
            return;
        }
        empList.forEach(System.out::println);
    }

    static void searchEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : empList) {
            if (e.getId() == id) {
                System.out.println(e);
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    static void updateSalary() throws ValidationException {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Employee e : empList) {
            if (e.getId() == id) {
                System.out.print("Enter New Salary: ");
                double sal = sc.nextDouble();
                if (sal <= 0)
                    throw new ValidationException("Salary must be positive!");

                e.setSalary(sal);
                saveToFile();
                System.out.println("Salary Updated");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Iterator<Employee> it = empList.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                saveToFile();
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    static void sortEmployees() {
        Collections.sort(empList);
        displayEmployees();
    }

    static void displayDepartments() {
        Set<String> depts = new HashSet<>();
        for (Employee e : empList)
            depts.add(e.getDepartment());

        System.out.println("Departments:");
        depts.forEach(System.out::println);
    }

    static void saveToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(empList);
        } catch (IOException e) {
            System.out.println("File Save Error");
        }
    }

    static void loadFromFile() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            empList = (ArrayList<Employee>) ois.readObject();
        } catch (Exception e) {
            empList = new ArrayList<>();
        }
    }
}

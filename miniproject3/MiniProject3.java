package miniproject3;

import java.util.*;

public class MiniProject3 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        if (!login()) {
            System.out.println("Invalid Login! Program Terminated.");
            return;
        }

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Eno");
            System.out.println("4. Update Student Branch");
            System.out.println("5. Delete Student by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> displayStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateBranch();
                    case 5 -> deleteStudent();
                    case 6 -> sortStudents();
                    case 7 -> {
                        System.out.println("Thank You!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Choice");
                }
            } catch (ValidationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // ================= LOGIN =================
    static boolean login() {
        String USERNAME = "admin";
        String PASSWORD = "admin123";

        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        return u.equals(USERNAME) && p.equals(PASSWORD);
    }

    // ================= ADD STUDENT =================
    static void addStudent() throws ValidationException {

        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();

        for (Student s : students)
            if (s.getEno() == eno)
                throw new ValidationException("Enrollment Number must be unique!");

        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Semester: ");
        String sem = sc.nextLine();
        if (sem.isEmpty())
            throw new ValidationException("Semester cannot be empty!");

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();
        if (branch.isEmpty())
            throw new ValidationException("Branch cannot be empty!");

        System.out.print("Enter Percentage: ");
        double per = sc.nextDouble();
        if (per <= 0)
            throw new ValidationException("Percentage must be positive!");

        students.add(new Student(eno, name, sem, branch, per));
        System.out.println("Student Added Successfully");
    }

    // ================= DISPLAY =================
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Found");
            return;
        }
        students.forEach(System.out::println);
    }

    // ================= SEARCH =================
    static void searchStudent() {
        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    // ================= UPDATE =================
    static void updateBranch() throws ValidationException {
        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.print("Enter New Branch: ");
                String branch = sc.nextLine();
                if (branch.isEmpty())
                    throw new ValidationException("Branch cannot be empty!");

                s.setBranch(branch);
                System.out.println("Branch Updated Successfully");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    // ================= DELETE =================
    static void deleteStudent() {
        System.out.print("Enter Enrollment No: ");
        int eno = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getEno() == eno) {
                it.remove();
                System.out.println("Student Deleted Successfully");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    // ================= SORT =================
    static void sortStudents() {
        Collections.sort(students);
        displayStudents();
    }
}

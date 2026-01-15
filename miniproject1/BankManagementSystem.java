package miniproject1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankManagementSystem {

    static final String FILE_NAME = "accounts.dat";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> displayDetails();
                case 6 -> {
                    System.out.println("Thank You!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    // ================== FILE METHODS ==================
    static void saveAccount(BankAccount acc) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {

            oos.writeObject(acc);

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }

    static List<BankAccount> readAccounts() {
        List<BankAccount> list = new ArrayList<>();
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            while (true) {
                list.add((BankAccount) ois.readObject());
            }

        } catch (EOFException e) {
            return list;
        } catch (Exception e) {
            return list;
        }
    }

    static void updateFile(List<BankAccount> list) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            for (BankAccount acc : list) {
                oos.writeObject(acc);
            }

        } catch (IOException e) {
            System.out.println("Update Error");
        }
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.print("Account Type (1-Savings / 2-Current): ");
        int type = sc.nextInt();

        BankAccount acc;

        // Runtime polymorphism
        if (type == 1) {
            acc = new SavingsAccount(accNo, name, bal);
        } else {
            acc = new CurrentAccount(accNo, name, bal);
        }

        saveAccount(acc);
        System.out.println("Account Created Successfully");
    }

    static BankAccount findAccount(int accNo, List<BankAccount> list) {
        for (BankAccount acc : list) {
            if (acc.accountNumber == accNo)
                return acc;
        }
        return null;
    }

    static void deposit() {
        List<BankAccount> list = readAccounts();
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo, list);
        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.deposit(amt); 
            updateFile(list);
        } else {
            System.out.println("Account Not Found");
        }
    }

    static void withdraw() {
        List<BankAccount> list = readAccounts();
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo, list);
        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
            updateFile(list);
        } else {
            System.out.println("Account Not Found");
        }
    }

    static void checkBalance() {
        List<BankAccount> list = readAccounts();
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo, list);
        if (acc != null) {
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account Not Found");
        }
    }

    static void displayDetails() {
        List<BankAccount> list = readAccounts();
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        BankAccount acc = findAccount(accNo, list);
        if (acc != null) {
            acc.displayDetails();
        } else {
            System.out.println("Account Not Found");
        }
    }
}

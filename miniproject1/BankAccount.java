package miniproject1;

import java.io.*;

abstract class BankAccount implements Serializable {
    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Abstract methods
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    // Concrete method
    public void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }

    public double getBalance() {
        return balance;
    }
}


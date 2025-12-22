import java.util.Scanner;

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

class BankAccount{
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) throws InsufficientBalanceException{
        if (amount <= 0){
            System.out.println("Invalid withdrawal amount!");
            return;
        }
        if (amount > balance){
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }

    public double getBalance(){
        return balance;
    }

    public void displayAccountDetails(){
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class Assignment15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true){
            System.out.println("\n=== BANK MANAGEMENT SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try{
                switch (choice){
                    case 1:
                        System.out.print("Enter Account Number: ");
                        int accNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();
                        account = new BankAccount(accNo, name, bal);
                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                        if (account == null) {
                            System.out.println("Create account first!");
                            break;
                        }
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 3:
                        if (account == null){
                            System.out.println("Create account first!");
                            break;
                        }
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 4:
                        if (account == null){
                            System.out.println("Create account first!");
                            break;
                        }
                        System.out.println("Current Balance: Rs" + account.getBalance());
                        break;

                    case 5:
                        if (account == null){
                            System.out.println("Create account first!");
                            break;
                        }
                        account.displayAccountDetails();
                        break;

                    case 6:
                        System.out.println("Thank you for using Bank Management System!");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

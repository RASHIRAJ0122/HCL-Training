package miniproject1;

class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn Successfully");
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}
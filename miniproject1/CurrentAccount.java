package miniproject1;

class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    @Override
    void withdraw(double amount) {
        balance -= amount; 
        System.out.println("Amount Withdrawn Successfully");
    }
}
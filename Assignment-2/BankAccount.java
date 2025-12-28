class BankAccount implements BankingOperations, CustomerOperations {
    private String customerName;
    private int accountNumber;
    private double balance;

    BankAccount(String name, int accNo, double balance) {
        this.customerName = name;
        this.accountNumber = accNo;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount");
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException{
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient Balance");
        balance -= amount;
    }

    public double checkBalance(){
        return balance;
    }

    public void displayCustomerDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        try {
            BankAccount acc = new BankAccount("Rashi", 101, 5000);
            acc.deposit(2000);
            acc.withdraw(3000);
            acc.displayCustomerDetails();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
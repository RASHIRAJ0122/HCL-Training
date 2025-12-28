interface BankingOperations {
    void deposit(double amount);
    void withdraw(double amount) throws Exception;
    double checkBalance();
}

package pl.edu.pwsztar;

public class Account {
    private int balance;
    private final int accountNumber;

    public Account(int accountNumber, int balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

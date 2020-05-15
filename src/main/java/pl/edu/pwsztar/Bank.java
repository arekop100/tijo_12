package pl.edu.pwsztar;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Bank implements BankOperation {

    private final List<Account> accountList = new ArrayList<>();

    private static int accountNumber = 0;

    public void addSampleAccounts(List<Account> accounts){
        accountList.addAll(accounts);
        accountNumber = accounts.size();
    }

    public int createAccount() {
        accountList.add(new Account(++accountNumber, 0));
        return accountNumber;
    }

    public int deleteAccount(int accountNumber) {
        int balance = ACCOUNT_NOT_EXISTS;

        Account account = findAccount(accountNumber).orElse( new Account(ACCOUNT_NOT_EXISTS,0));
        if (account.getAccountNumber() != ACCOUNT_NOT_EXISTS) {
            balance = account.getBalance();
            accountList.remove(account);
            Bank.accountNumber--;
        }
        return balance;


    }

    public boolean deposit(int accountNumber, int amount) {
        Account account = findAccount(accountNumber).orElse( new Account(ACCOUNT_NOT_EXISTS,0));

        if(account.getAccountNumber() != ACCOUNT_NOT_EXISTS && amount > 0){
            account.setBalance(account.getBalance() + amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(int accountNumber, int amount) {
        if(amount <= 0){
            return false;
        }

        Account account = findAccount(accountNumber).orElse( new Account(ACCOUNT_NOT_EXISTS,0));

        if(account.getAccountNumber() != ACCOUNT_NOT_EXISTS && account.getBalance() >= amount){
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;
    }

    public boolean transfer(int fromAccount, int toAccount, int amount) {
        if(fromAccount == toAccount || amount <= 0){
            return false;
        }

        Account fromAcc = findAccount(fromAccount).orElse( new Account(ACCOUNT_NOT_EXISTS,0));
        Account toAcc = findAccount(toAccount).orElse( new Account(ACCOUNT_NOT_EXISTS,0));

        if(fromAcc.getAccountNumber() != ACCOUNT_NOT_EXISTS && toAcc.getAccountNumber() != ACCOUNT_NOT_EXISTS
                && fromAcc.getBalance() >= amount){

            fromAcc.setBalance(fromAcc.getBalance() - amount);
            toAcc.setBalance(toAcc.getBalance() + amount);
            return true;
        }

        return false;
    }

    public int accountBalance(int accountNumber) {
        Account account = findAccount(accountNumber).orElse( new Account(ACCOUNT_NOT_EXISTS,0));

        if(account.getAccountNumber() != ACCOUNT_NOT_EXISTS){
            return account.getBalance();
        }

        return ACCOUNT_NOT_EXISTS;
    }

    public int sumAccountsBalance() {

        return accountList.stream().mapToInt(Account::getBalance).sum();
    }

    private Optional<Account> findAccount(int accountNumber){
        for(Account account : accountList){
            if(account.getAccountNumber() == accountNumber){
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }


}

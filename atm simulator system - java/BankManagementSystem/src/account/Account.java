package account;

import java.io.Serializable;

public abstract class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String name;
    protected String fatherName;
    protected String cnic;
    protected boolean filer;

    protected String accountNumber;
    protected String pin;
    protected double balance;

    public Account(String name, String fatherName, String cnic,
                   boolean filer, String accountNumber, String pin) {

        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.filer = filer;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance)
            return false;
        balance -= amount;
        return true;
    }
}

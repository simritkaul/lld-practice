package com.simrit.responsibilities;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final WithdrawalPublisher withdrawalPublisher;

    public BankAccount(String accountNumber, double balance, WithdrawalPublisher withdrawalPublisher) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) throw new IllegalArgumentException("Account Number cannot be null or empty");
        if (balance < 0.0) throw new IllegalArgumentException("Balance cannot be negative");
        if (withdrawalPublisher == null) throw new IllegalArgumentException("Withdrawal publisher cannot be null");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.withdrawalPublisher = withdrawalPublisher;
    }

    public double getBalance() { return this.balance; }
    public String getAccountNumber() { return this.accountNumber; }

    public void withdraw(double amount) {
        if (amount < 0.0) throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        if (this.balance < amount) throw new IllegalStateException("Cannot withdraw Rs." + amount);
        this.balance -= amount;
        System.out.println("Rs." + amount + " withdrawn successfully");
        withdrawalPublisher.onWithdrawal(this, amount);
    }

    public void deposit(double amount) {
        if (amount < 0.0) throw new IllegalArgumentException("Deposit amount cannot be negative");
        this.balance += amount;
        System.out.println("Rs." + amount + " deposited successfully");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BankAccount other)) return false;
        return this.accountNumber.equals(other.getAccountNumber());
    }

    @Override
    public int hashCode() {
        return this.accountNumber.hashCode();
    }
}

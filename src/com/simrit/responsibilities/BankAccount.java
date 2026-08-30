package com.simrit.responsibilities;

public class BankAccount {
    private double balance;
    private final WithdrawalPublisher withdrawalPublisher;

    public BankAccount(double balance, WithdrawalPublisher withdrawalPublisher) {
        if (balance < 0.0) throw new IllegalArgumentException("Balance cannot be negative");
        if (withdrawalPublisher == null) throw new IllegalArgumentException("Withdrawal publisher cannot be null");
        this.balance = balance;
        this.withdrawalPublisher = withdrawalPublisher;
    }

    public double getBalance() { return this.balance; }

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
}

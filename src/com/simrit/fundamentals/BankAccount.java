package com.simrit.fundamentals;

public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount (String accountHolder) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account Holder cannot be null or blank");
        }
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0.0) return false;
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (this.balance < amount || amount <= 0.0) return false;
        this.balance -= amount;
        return true;
    }

    public String getAccountSummary() {
        return "A/C of " + this.accountHolder + " - Current Balance Rs." + this.balance;
    }
}

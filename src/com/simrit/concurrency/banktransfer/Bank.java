package com.simrit.concurrency.banktransfer;

public class Bank {
    public void transfer(Account from, Account to, double amount) {
        Account first;
        Account second;

        if (from.getId().compareTo(to.getId()) < 0) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {
            if (from.withdraw(amount)) {
                    to.deposit(amount);
                }
            }
        }
    }
}

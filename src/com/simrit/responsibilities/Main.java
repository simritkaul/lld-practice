package com.simrit.responsibilities;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        runBank();
    }

    private static void runBank() {
        WithdrawalPublisher withdrawalPublisher = new WithdrawalPublisher();
        withdrawalPublisher.subscribe(new NotificationHandler());
        withdrawalPublisher.subscribe(new AuditLogger());

        BankAccount bankAccount = new BankAccount(1000.0, withdrawalPublisher);
        bankAccount.deposit(250.50);
//        bankAccount.withdraw(-100);
        bankAccount.withdraw(800);
        System.out.println("Balance: " + bankAccount.getBalance());
    }
}

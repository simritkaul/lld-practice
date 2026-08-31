package com.simrit.responsibilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        runBank();
    }

    private static void runBank() {
        WithdrawalPublisher withdrawalPublisher = new WithdrawalPublisher();
        withdrawalPublisher.subscribe(new NotificationHandler());
        withdrawalPublisher.subscribe(new AuditLogger());
        withdrawalPublisher.unsubscribe(new NotificationHandler());

        BankAccount bankAccount = new BankAccount("101", 1000.0, withdrawalPublisher);
        BankAccount otherBankAccount = new BankAccount("101", 1000.0, withdrawalPublisher);

        System.out.println("== : " + (bankAccount == otherBankAccount));
        System.out.println("equals: " + bankAccount.equals(otherBankAccount));
        System.out.println("HashCode of bankAccount: " + bankAccount.hashCode());
        System.out.println("HashCode of otherBankAccount: " + otherBankAccount.hashCode());

        Set<BankAccount> bankAccounts = new HashSet<>();
        bankAccounts.add(bankAccount);
        bankAccounts.add(otherBankAccount);
        System.out.println("Size of bankAccounts: " + bankAccounts.size());

        bankAccount.deposit(250.50);
//        bankAccount.withdraw(-100);
        bankAccount.withdraw(800);
        System.out.println("Balance: " + bankAccount.getBalance());
    }
}

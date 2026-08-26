package com.simrit.fundamentals;

public class Main {
    public static void main(String[] args) {
        runBackAccount();
    }

    private static void runBackAccount() {
        BankAccount bankAccount = new BankAccount("Simrit");
        System.out.println(bankAccount.getAccountSummary());

        bankAccount.deposit(2400);
        System.out.println(bankAccount.getAccountSummary());
        bankAccount.deposit(-1550.50);
        System.out.println(bankAccount.getAccountSummary());
        bankAccount.withdraw(5000);
        System.out.println(bankAccount.getAccountSummary());
        bankAccount.withdraw(-1020);
        System.out.println(bankAccount.getAccountSummary());
        bankAccount.withdraw(1020);
        System.out.println(bankAccount.getAccountSummary());
    }
}

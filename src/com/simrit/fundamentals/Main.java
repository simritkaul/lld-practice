package com.simrit.fundamentals;

public class Main {
    public static void main(String[] args) {
//        runBackAccount();
        runCart();
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

    private static void runCart() {
        CartProduct laptop = new CartProduct(1, "Laptop", 129000.0);
        CartProduct mouse = new CartProduct(2, "Mouse", 6995.0);
        CartProduct keyboard = new CartProduct(3, "Keyboard", 5975.5);

        ShoppingCart cart = new ShoppingCart();
        System.out.println(cart.getItems().toString());
        cart.addItem(laptop, 1);
        cart.addItem(mouse, 1);
        System.out.println(cart.getItems().toString());
        cart.addItem(keyboard, 2);
        cart.addItem(mouse, 3);
        System.out.println(cart.getItems().toString());
    }
}

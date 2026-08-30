package com.simrit.responsibilities;

public class NotificationHandler implements WithdrawalListener {
    @Override
    public void onWithdrawal(BankAccount account, double amount) {
        System.out.println("Notification sent: Successfully withdrawn Rs." + amount + ".");
    }
}

package com.simrit.responsibilities;

import java.time.LocalDateTime;

public class AuditLogger implements WithdrawalListener{
    @Override
    public void onWithdrawal(BankAccount account, double amount) {
        System.out.println("Audit Logged: Withdrawal Amount - Rs." + amount + " at " + LocalDateTime.now());
    }
}

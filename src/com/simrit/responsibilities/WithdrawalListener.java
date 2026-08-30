package com.simrit.responsibilities;

public interface WithdrawalListener {
    void onWithdrawal(BankAccount account, double amount);
}

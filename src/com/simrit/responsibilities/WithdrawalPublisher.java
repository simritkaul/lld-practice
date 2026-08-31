package com.simrit.responsibilities;

import java.util.ArrayList;
import java.util.List;

public class WithdrawalPublisher {
    private List<WithdrawalListener> withdrawalListeners;

    public WithdrawalPublisher () {
        this.withdrawalListeners = new ArrayList<>();
    }

    public void subscribe(WithdrawalListener withdrawalListener) {
        if (withdrawalListener == null) throw new IllegalArgumentException("Withdrawal listener cannot be null");
        withdrawalListeners.add(withdrawalListener);
    }

    public void unsubscribe(WithdrawalListener withdrawalListener) {
        if (withdrawalListener == null) throw new IllegalArgumentException("Withdrawal listener cannot be null");
        withdrawalListeners.remove(withdrawalListener);
    }

    public void onWithdrawal(BankAccount account, double amount) {
        for (WithdrawalListener listener : withdrawalListeners) {
            listener.onWithdrawal(account, amount);
        }
    }
}

package com.simrit.concurrency.inventory;

public class Inventory {
    private int stock = 0;

    public synchronized void addStock(int quantity) {
        stock += quantity;
    }

    public synchronized boolean purchase(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
            return true;
        }

        return false;
    }

    public synchronized int getStock() {
        return stock;
    }
}

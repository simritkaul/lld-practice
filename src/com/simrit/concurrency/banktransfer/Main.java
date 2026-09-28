package com.simrit.concurrency.banktransfer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int workerCount = 4;
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Account a = new Account("1", 1000);
        Account b = new Account("2", 1000);

        ExecutorService executor = Executors.newFixedThreadPool(workerCount);

        CountDownLatch latch = new CountDownLatch(workerCount);

        // Worker 1
        executor.submit(() -> {
            try {
                bank.transfer(a, b, 10);
                System.out.println("Worker 1 Transfer Done");
            } finally {
                latch.countDown();
            }
        });

        // Worker 2
        executor.submit(() -> {
            try {
                bank.transfer(b, a, 10);
                System.out.println("Worker 2 Transfer Done");
            } finally {
                latch.countDown();
            }
        });

        // Worker 3
        executor.submit(() -> {
            try {
                bank.transfer(b, a, 30);
                System.out.println("Worker 3 Transfer Done");
            } finally {
                latch.countDown();
            }
        });

        // Worker 4
        executor.submit(() -> {
            try {
                bank.transfer(a, b, 30);
                System.out.println("Worker 4 Transfer Done");
            } finally {
                latch.countDown();
            }
        });

        latch.await();

        System.out.println("All transactions done!");

        System.out.println("Final Balance in Account A: $" + a.getBalance() + " and Account B: $" + b.getBalance());
        System.out.println("Total amount: $" + (a.getBalance() + b.getBalance()));

        executor.shutdown();
    }
}

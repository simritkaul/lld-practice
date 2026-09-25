package com.simrit.concurrency;

import com.simrit.concurrency.counter.Counter;
import com.simrit.concurrency.inventory.Inventory;
import com.simrit.concurrency.worker.Worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        runExecutor();
    }

    private static void runCounter() throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100_000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Total Count is : " + counter.getCount());
    }

    private static void runWorker() throws InterruptedException {
        Worker worker = new Worker();

        Thread workerThread = new Thread(worker::run);

        workerThread.start();

        Thread.sleep(1000);

        worker.stop();

        System.out.println("Stop Requested");
        workerThread.join();

        System.out.println("runWorker finished");
    }

    private static void runInventory() throws InterruptedException {
        Inventory inventory = new Inventory();
        inventory.addStock(1000);

        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 1000; i++) {
               inventory.purchase(1);
           }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                inventory.purchase(1);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final stock left: " + inventory.getStock());
    }

    private static void runExecutor() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int taskId = i;

//            executor.submit(() -> {
//                System.out.println("Task " + taskId + " running on " + Thread.currentThread().getName());
//            });

            executor.submit(() -> {
                System.out.println("Started task " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Finished task " + taskId);
            });
        }

        executor.shutdown();
    }
}

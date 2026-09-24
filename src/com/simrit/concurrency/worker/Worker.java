package com.simrit.concurrency.worker;

public class Worker {
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            // Do some work
        }

        System.out.println("Worker Stopped");
    }
}

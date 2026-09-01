package com.simrit.collections;

public class Main {
    public static void main(String[] args) {
        runTasks();
    }

    private static void runTasks() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(new Task("101", "Test basic task manager", 3));
        taskManager.addTask(new Task("102", "Just run this quick!!", 5));
        taskManager.addTask(new Task("103", "Low Priority, chill...", 1));
        taskManager.addTask(new Task("104", "DO ASAP!", 4));
        taskManager.printTasks();

        System.out.println(taskManager.findTask("103"));

        taskManager.processNextTask();
        taskManager.processNextTask();

//        taskManager.findTask("104");

        taskManager.printTasks();
    }
}

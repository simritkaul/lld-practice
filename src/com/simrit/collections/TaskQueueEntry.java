package com.simrit.collections;

public class TaskQueueEntry {
    private final Task task;
    private final long insertionOrder;

    public TaskQueueEntry(Task task, long insertionOrder) {
        if (task == null) throw new IllegalArgumentException("Task cannot be null");
        if (insertionOrder <= 0) throw new IllegalArgumentException("Insertion order cannot be negative or 0");

        this.task = task;
        this.insertionOrder = insertionOrder;
    }

    public Task getTask() { return task; }

    public long getInsertionOrder() {
        return insertionOrder;
    }
}

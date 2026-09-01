package com.simrit.collections;

import com.simrit.helpers.ValidationHelper;

public class Task {
    private final String id;
    private final String description;
    private int priority;

    public Task(String id, String description, int priority) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalArgumentException("ID cannot be null or empty");
        if (ValidationHelper.isNullOrEmpty(description)) throw new IllegalArgumentException("Description cannot be null or empty");
        if (priority <= 0) throw new IllegalArgumentException("Priority cannot be negative or 0");
        if (priority > 5) throw new IllegalArgumentException("Priority cannot be greater than 5");

        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }

    @Override
    public String toString() {
        return "Task ID " + id + " : " + description;
    }
}

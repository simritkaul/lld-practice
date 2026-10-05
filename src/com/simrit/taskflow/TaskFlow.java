package com.simrit.taskflow;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;
import com.simrit.taskflow.task.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskFlow {
    private final Map<String, Task> tasks;

    public TaskFlow() {
        tasks = new HashMap<>();
    }

    public void submit(Task task) {
        if (task == null) throw new IllegalArgumentException("Task cannot be null");
        tasks.put(task.getId(), task);
    }

    public boolean execute(String taskId) {
        if (ValidationHelper.isNullOrEmpty(taskId)) throw new IllegalStringArgumentException("Task ID");
        Task task = tasks.get(taskId);
        if (task == null) throw new IllegalStateException("Task with ID " + taskId + " does not exist");
        return task.run();
    }
}

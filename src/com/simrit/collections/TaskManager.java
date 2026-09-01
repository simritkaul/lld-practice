package com.simrit.collections;

import com.simrit.helpers.ValidationHelper;

import java.util.*;

public class TaskManager {
    private final Map<String, TaskQueueEntry> idTaskMap;
    private final PriorityQueue<TaskQueueEntry> tasksByPriority;
    private long insertionOrderId;

    public TaskManager() {
        idTaskMap = new LinkedHashMap<>();
        Comparator<TaskQueueEntry> taskQueueEntryComparator = (a, b) -> {
            if (a.getTask().getPriority() == b.getTask().getPriority()) {
                return Long.compare(b.getInsertionOrder(), a.getInsertionOrder());
            }

            return Integer.compare(b.getTask().getPriority(), a.getTask().getPriority());
        };
        tasksByPriority = new PriorityQueue<>(taskQueueEntryComparator);
        insertionOrderId = 1;
    }

    public void addTask(Task task) {
        if (task == null) throw new IllegalArgumentException("Task cannot be null");
        if (idTaskMap.containsKey(task.getId())) throw new IllegalArgumentException("Task already exists");
        TaskQueueEntry taskQueueEntry = new TaskQueueEntry(task, insertionOrderId++);
        idTaskMap.put(task.getId(), taskQueueEntry);
        tasksByPriority.add(taskQueueEntry);
    }

    public Task findTask(String id) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalArgumentException("Id cannot be null or empty");
        if (!idTaskMap.containsKey(id)) throw new IllegalArgumentException("Task with Id " + id + " does not exist");
        return idTaskMap.get(id).getTask();
    }

    public void removeTask(String id) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalArgumentException("Id cannot be null or empty");
        if (!idTaskMap.containsKey(id)) throw new IllegalArgumentException("Task with Id " + id + " does not exist");

        TaskQueueEntry taskEntryToRemove = idTaskMap.get(id);
        if (taskEntryToRemove != null) {
            tasksByPriority.remove(taskEntryToRemove);
        }
        idTaskMap.remove(id);
    }

    public void printTasks() {
        for (TaskQueueEntry taskEntry : idTaskMap.values()) {
            System.out.println(taskEntry.getTask());
        }
    }

    public void processNextTask() {
        if (tasksByPriority.isEmpty()) return;

        TaskQueueEntry taskToProcess = tasksByPriority.peek();
        System.out.println("Task Processed => " + taskToProcess.getTask());

        removeTask(taskToProcess.getTask().getId());
    }
}

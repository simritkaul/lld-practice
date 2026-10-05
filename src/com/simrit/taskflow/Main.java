package com.simrit.taskflow;

import com.simrit.taskflow.task.EmailTask;
import com.simrit.taskflow.task.ReportTask;
import com.simrit.taskflow.task.Task;

public class Main {
    public static void main(String[] args) {
        TaskFlow taskFlow = new TaskFlow();
        Task t1 = new EmailTask("1", "Approval for leave");
        Task t2 = new ReportTask("2", "Q2 Sales");
        taskFlow.submit(t1);
        taskFlow.submit(t2);
        taskFlow.execute("2");
        taskFlow.execute("1");
    }
}

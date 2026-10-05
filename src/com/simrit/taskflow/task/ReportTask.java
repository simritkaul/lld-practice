package com.simrit.taskflow.task;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public class ReportTask extends AbstractTask implements Task {
    public ReportTask(String id, String name) {
        super(id, name);
    }

    public boolean run() {
        System.out.println("Generating Report: " + this.getName());
        return true;
    }
}

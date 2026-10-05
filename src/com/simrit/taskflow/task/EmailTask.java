package com.simrit.taskflow.task;

public class EmailTask extends AbstractTask implements Task {
    public EmailTask(String id, String name) {
        super(id, name);
    }

    public boolean run() {
        System.out.println("Sending Email: " + this.getName());
        return true;
    }
}

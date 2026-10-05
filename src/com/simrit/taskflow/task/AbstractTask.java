package com.simrit.taskflow.task;

import com.simrit.helpers.IllegalStringArgumentException;
import com.simrit.helpers.ValidationHelper;

public abstract class AbstractTask {
    private final String id;
    private final String name;

    protected AbstractTask(String id, String name) {
        if (ValidationHelper.isNullOrEmpty(id)) throw new IllegalStringArgumentException("ID");
        if (ValidationHelper.isNullOrEmpty(name)) throw new IllegalStringArgumentException("Name");
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

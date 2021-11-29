package com.example.todo.storage;

import lombok.Data;

@Data
public class TaskStatus {
    private String task;
    private boolean status;

    public TaskStatus(String task) {
        this.task = task;
        this.status = false;
    }
}

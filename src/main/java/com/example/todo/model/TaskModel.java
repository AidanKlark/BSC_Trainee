package com.example.todo.model;

import lombok.Data;

@Data
public class TaskModel {
    private String task;
    private boolean status;

    public TaskModel(TaskDescription taskDescription) {
        this.task = taskDescription.getTaskDescription();
        this.status = false;
    }
}

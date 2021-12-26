package com.example.todo.service;

import com.example.todo.models.TaskDescription;
import com.example.todo.models.TaskEntity;
import java.util.List;

public interface TaskService {

    void toggleTask(Long id);
    void editTask(Long id, TaskDescription taskDescription);
    List<TaskEntity> getTasks(Boolean all, String substring);
    void addTask(TaskDescription description, String username);
    void deleteTask(Long id);
}

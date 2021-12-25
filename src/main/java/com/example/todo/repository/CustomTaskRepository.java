package com.example.todo.repository;

import com.example.todo.models.TaskEntity;

import java.util.List;

public interface CustomTaskRepository {

    List<TaskEntity> getTasks(Boolean all, String substring);
}

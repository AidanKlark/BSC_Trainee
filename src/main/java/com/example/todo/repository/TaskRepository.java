package com.example.todo.repository;

import com.example.todo.models.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long>, CustomTaskRepository {}

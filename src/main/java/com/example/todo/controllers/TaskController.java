package com.example.todo.controllers;

import com.example.todo.models.TaskDescription;
import com.example.todo.models.TaskEntity;
import com.example.todo.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@Validated
@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public void createTask(@Valid @RequestBody TaskDescription taskDescription){
        log.info("Добавлена задача: {}", taskDescription.getTaskDescription());
        taskRepository.save(new TaskEntity(taskDescription, false));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable @Min(1) Long id){
        log.info("Удаление по ID: {}", id);
        taskRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    @Transactional
    public void updateTask(@PathVariable @Min(1) Long id, @Valid @RequestBody TaskDescription taskDescription){
        log.info("Изменение задачи: {}: {}", id, taskDescription.getTaskDescription());
        taskRepository.editTask(id, taskDescription.getTaskDescription());
    }

    @PatchMapping("/{id}/status")
    @Transactional
    public void updateStatusTask(@PathVariable @Min(1) Long id){
        log.info("Изменение статуса по ID: {}", id);
        taskRepository.toggleTask(id);
    }

    @GetMapping
    public List<TaskEntity> getTasks(@RequestParam(name = "all", required = false)
                                                 Boolean all,
                                     @RequestParam(name = "substring", required = false, defaultValue = "")
                                             String substring) {

        return taskRepository.getTasks(all, substring);
    }
}

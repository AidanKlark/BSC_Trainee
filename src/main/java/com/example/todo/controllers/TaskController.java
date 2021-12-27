package com.example.todo.controllers;

import com.example.todo.models.TaskDescription;
import com.example.todo.models.TaskEntity;
import com.example.todo.models.AccountEntity;
import com.example.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskService service;

    @PostMapping
    public void createTask(@Valid @RequestBody TaskDescription taskDescription,
                           @AuthenticationPrincipal AccountEntity accountEntity) {

        log.info("Добавлена задача: {}", taskDescription.getTaskDescription());
        service.addTask(taskDescription, accountEntity.getUsername());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable @Min(1) Long id) {

        log.info("Удаление по ID: {}", id);
        service.deleteTask(id);
    }

    @PatchMapping("/{id}")
    @Transactional
    public void updateTask(@PathVariable @Min(1) Long id, @Valid @RequestBody TaskDescription taskDescription) {

        log.info("Изменение задачи: {}: {}", id, taskDescription.getTaskDescription());
        service.editTask(id, taskDescription);
    }

    @PatchMapping("/{id}/status")
    @Transactional
    public void updateStatusTask(@PathVariable @Min(1) Long id) {

        log.info("Изменение статуса по ID: {}", id);
        service.toggleTask(id);
    }

    @GetMapping
    public List<TaskEntity> getTasks(@RequestParam(name = "all", required = false)
                                                 Boolean all,
                                     @RequestParam(name = "substring", required = false, defaultValue = "")
                                             String substring) {

        return service.getTasks(all, substring);
    }
}

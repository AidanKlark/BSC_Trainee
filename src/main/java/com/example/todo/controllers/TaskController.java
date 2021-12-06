package com.example.todo.controllers;

import com.example.todo.model.TaskDescription;
import com.example.todo.model.TaskModel;
import com.example.todo.service.IService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final IService taskService;

    @PostMapping
    public void createTask(@Valid @RequestBody TaskDescription taskDescription){
        log.info("Добавлена задача: {}", taskDescription.getTaskDescription());
        taskService.add(taskDescription);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable @Min(1) Integer id){
        log.info("Удаление по ID: {}", id);
        taskService.delete(id);
    }

    @PatchMapping("/{id}")
    public void updateTask(@PathVariable @Min(1) Integer id, @Valid @RequestBody TaskDescription taskDescription){
        log.info("Изменение задачи: {}: {}", id, taskDescription);
        taskService.edit(id, taskDescription);
    }

    @PatchMapping("/{id}/status")
    public void updateStatusTask(@PathVariable @Min(1) Integer id){
        log.info("Изменение статуса по ID: {}", id);
        taskService.toggle(id);
    }

    @GetMapping
    public Map<Integer, TaskModel> getTasks(@RequestParam(name = "all", required = false) Boolean all,
                                            @RequestParam(name = "substring", required = false) String substring) {

        return taskService.getTasks(all, substring);
    }
}

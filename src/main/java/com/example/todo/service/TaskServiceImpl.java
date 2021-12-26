package com.example.todo.service;

import com.example.todo.models.TaskDescription;
import com.example.todo.models.TaskEntity;
import com.example.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final AccountService userService;

    public void toggleTask(Long id) {
        TaskEntity task = repository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Задачи с таким id: " + id + "не существует"));
        task.setCompleted(!task.getCompleted());
        repository.save(task);
    }

    public void editTask(Long id, TaskDescription taskDescription) {
        TaskEntity task = repository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Задачи с таким id: " + id + "не существует"));
        task.setDescription(taskDescription.getTaskDescription());
        task.setCompleted(false);
        repository.save(task);
    }


    public List<TaskEntity> getTasks(Boolean all, String substring) {
        return repository.getTasks(all, substring,
                userService.getAccountByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
    }

    @Override
    public void addTask(TaskDescription description, String username) {
        repository.save(new TaskEntity(description, false, userService.getAccountByUsername(username)));
    }

    @Override
    public void deleteTask(Long id) {
        TaskEntity task = repository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Задачи с таким id: " + id + "не существует"));
        repository.delete(task);
    }
}

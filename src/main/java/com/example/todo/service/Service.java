package com.example.todo.service;

import com.example.todo.model.TaskDescription;
import com.example.todo.model.TaskModel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service implements IService{

    private final Map<Integer, TaskModel> allTask = new HashMap<>();
    private int id = 1;

    @Override
    public void add(TaskDescription taskDescription) {
        allTask.put(id++, new TaskModel(taskDescription));
    }

    @Override
    public void delete(Integer idTask) {
        allTask.entrySet().removeIf(a -> a.getKey() == idTask);
    }

    @Override
    public void edit(Integer idTask, TaskDescription taskDescription) {
        allTask.get(idTask).setTask(taskDescription.getTaskDescription());
        allTask.get(idTask).setStatus(false);
    }

    @Override
    public void toggle(Integer idTask) {
        TaskModel newStatus = allTask.get(idTask);
        allTask.get(idTask).setStatus(!newStatus.isStatus());
    }

    @Override
    public Map<Integer, TaskModel> getTasks(Boolean all, String substring) {

        Map<Integer, TaskModel> filterTasks = new HashMap<>(Collections.emptyMap());

        if (all == null && substring == null) {
            allTask.entrySet().stream()
                    .filter(a -> !a.getValue().isStatus())
                    .forEach(a -> filterTasks.put(a.getKey(), a.getValue()));;

        } else if (substring != null) {
             allTask.entrySet().stream()
                    .filter(a -> a.getValue().getTask().contains(substring))
                    .forEach(a -> filterTasks.put(a.getKey(), a.getValue()));

        } else if (all) {
             return allTask;
        }

        return filterTasks;
    }
}

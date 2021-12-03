package com.example.todo.service;

import com.example.todo.model.TaskDescription;
import com.example.todo.model.TaskModel;
import java.util.Map;

interface IService {

    void add(TaskDescription taskDescription);
    void delete(Integer id);
    void edit(Integer id, TaskDescription taskDescriptio);
    Map<Integer,TaskModel> getTasks(Boolean all, String target);
    void toggle(Integer id);

}

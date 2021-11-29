package com.example.todo.IO;

import com.example.todo.storage.TaskStatus;

public interface ICommandPrint {

    void out(Integer key, TaskStatus taskStatus);
}

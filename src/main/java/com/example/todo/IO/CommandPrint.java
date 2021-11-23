package com.example.todo.IO;

import com.example.todo.storage.TaskStatus;
import org.springframework.stereotype.Component;

@Component
public class CommandPrint implements ICommandPrint{

    private static ICommandPrint commandPrint;

    public static ICommandPrint getInstance() {
        if(commandPrint == null) {
            commandPrint = new CommandPrint();
        }

        return commandPrint;
    }

    @Override
    public void out(Integer key, TaskStatus taskStatus) {
        System.out.printf("%d. %s %s\n", key, taskStatus.isStatus() ? "[X]" : "[ ]", taskStatus.getTask());
    }
}

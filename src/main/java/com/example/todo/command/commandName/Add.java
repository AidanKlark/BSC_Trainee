package com.example.todo.command.commandName;

import com.example.todo.IO.IErrorPrint;
import com.example.todo.parse.IParser;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import com.example.todo.storage.StorageTask;
import com.example.todo.storage.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Add extends CommandBase {

    @Getter
    private static final String cmd = "add";

    @Autowired
    public Add(IParser parse, IErrorPrint errorPrint) {
        super(parse, errorPrint);
    }

    @Override
    public void accept(String command) {

            String task = parse.parseArgs(command);
            log.debug("Добавлена задача: {}", task);

            if (!task.isBlank()) {
                StorageTask.addTask(new TaskStatus(task));
            } else {
            errPrint.printError(IErrorPrint.NO_ARGS);
        }
    }
}

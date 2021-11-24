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
public class Edit extends CommandBase {

    @Getter
    private static final String cmd = "edit";

    @Autowired
    public Edit(IParser parse, IErrorPrint errorPrint) {
        super(parse, errorPrint);
    }

    @Override
    public void accept(String command) {

        int id = parse.parseId(command);
        log.debug("Редактирование задачи по ID: {}", id);

        TaskStatus newTask = StorageTask.getAllTask().get(id);

        if (newTask != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            newTask.setTask(parse.parseCmdEdit(command));
            newTask.setStatus(false);
        } else {
            errPrint.printError(IErrorPrint.NO_ID);
        }
    }
}

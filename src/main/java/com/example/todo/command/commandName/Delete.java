package com.example.todo.command.commandName;

import com.example.todo.IO.ErrorPrint;
import com.example.todo.parse.IParser;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import com.example.todo.storage.StorageTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Delete extends CommandBase {

    @Getter
    private final String cmd = "delete";

    @Autowired
    public Delete(IParser parse, ErrorPrint errorPrint) {
        super(parse, errorPrint);
    }

    @Override
    public void accept(String command) {

        log.info("Запуск класса Delete");

        int id = parse.parseId(command);

        if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            log.debug("Удаление задачи по ID: {}", id);
            StorageTask.removeTask(id);
        }
    }
}


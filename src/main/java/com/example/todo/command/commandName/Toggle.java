package com.example.todo.command.commandName;

import com.example.todo.IO.ErrorPrint;
import com.example.todo.IO.IErrorPrint;
import com.example.todo.parse.IParser;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import com.example.todo.storage.StorageTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Toggle extends CommandBase {

    @Getter
    private static final String cmd = "toggle";

    @Autowired
    public Toggle(IParser parse, ErrorPrint errorPrint) {
        super(parse, errorPrint);
    }

    @Override
    public void accept(String command) {

        log.info("Запуск класса Toggle");

        int id = parse.parseId(command);

        if (StorageTask.getAllTask().get(id) != null && id >= 1 && id <= StorageTask.getAllTask().size()) {
            StorageTask.getAllTask().get(id).setStatus(!StorageTask.getAllTask().get(id).isStatus());

        } else {
            errPrint.printError(IErrorPrint.NO_ID);
        }
    }
}

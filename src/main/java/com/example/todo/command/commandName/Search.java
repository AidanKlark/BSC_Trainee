package com.example.todo.command.commandName;

import com.example.todo.IO.ICommandPrint;
import com.example.todo.IO.IErrorPrint;
import com.example.todo.parse.IParser;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import com.example.todo.storage.StorageTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Search extends CommandBase {

    @Getter
    private static final String cmd = "search";

    @Autowired
    public Search(ICommandPrint commandPrint, IParser parse) {
        super(parse, commandPrint);
    }

    @Override
    public void accept(String command) {

        String substring = parse.parseArgs(command);
        log.debug("Поиск по ключевому слову: {}", substring);

        if (!substring.isBlank()) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> a.getValue().getTask().contains(substring))
                    .forEach(a -> cmdPrint.out(a.getKey(), a.getValue()));
        } else {
            errPrint.printError(IErrorPrint.NO_ARGS);
        }
    }
}


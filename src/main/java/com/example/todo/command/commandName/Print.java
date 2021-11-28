package com.example.todo.command.commandName;

import com.example.todo.IO.ICommandPrint;
import lombok.Getter;
import com.example.todo.storage.StorageTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Print extends CommandBase {

    @Getter
    private final String cmd = "print";

    private final static String ALL = "print all";

    @Autowired
    public Print(ICommandPrint commandPrint) {
        super(commandPrint);
    }

    @Override
    public void accept(String command) {

        if (!command.equals(ALL)) {
            StorageTask.getAllTask().entrySet().stream()
                    .filter(a -> !a.getValue().isStatus())
                    .forEach(a -> cmdPrint.out(a.getKey(), a.getValue()));
        } else {
            StorageTask.getAllTask().forEach(cmdPrint::out);
        }
    }
}


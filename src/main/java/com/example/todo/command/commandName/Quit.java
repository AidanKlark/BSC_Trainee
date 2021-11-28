package com.example.todo.command.commandName;

import com.example.todo.IO.ICommandPrint;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Quit extends CommandBase {

    @Getter
    private final String cmd = "quit";

    @Autowired
    public Quit(ICommandPrint commandPrint) {
        super(commandPrint);
    }

    @Override
    public void accept(String command) {
        System.exit(0);
    }
}

package com.example.todo.command;

import com.example.todo.command.commandName.ICommand;
import com.example.todo.parse.IParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandStart implements ICommandStart {

    private final CommandFactory commandFactory;

    @Autowired
    public CommandStart(CommandFactory  commandFactory, IParser parse) {
        this.commandFactory = commandFactory;
    }

    @Override
    public void start(String inputCmd) {
        ICommand command = commandFactory.getCommand(inputCmd);

        if (command != null) {
            command.accept(inputCmd);
        } else {
            System.out.println("Повторите команду");
        }
    }
}

package com.example.todo.command;

import com.example.todo.command.commandName.ICommand;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandFactory {

    @Getter
    private final Map<String, ICommand> commands;

    @Autowired
    public CommandFactory(List<ICommand> listCmd) {
        this.commands = new HashMap<>();
        for (ICommand i : listCmd)
            commands.put(i.getCmd(),i);
    }
}

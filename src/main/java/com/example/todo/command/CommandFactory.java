package com.example.todo.command;

import com.example.todo.command.commandName.ICommand;
import com.example.todo.parse.IParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandFactory {

    private final Map<String, ICommand> commands;
    private final IParser parse;

    @Autowired
    public CommandFactory(List<ICommand> listCmd, IParser parse) {
        this.commands = new HashMap<>();
        for (ICommand i : listCmd)
            commands.put(i.getCmd(),i);
        this.parse = parse;
    }

    public ICommand getCommand(String inputCmd) {
        return commands.get(parse.parseCmd(inputCmd));
    }
}

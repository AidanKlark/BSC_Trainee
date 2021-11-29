package com.example.todo.command;

import com.example.todo.command.commandName.ICommand;
import com.example.todo.parse.IParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CommandFactory {

    private final Map<String, ICommand> commands;
    private final IParser parse;

    @Autowired
    public CommandFactory(List<ICommand> listCmd, IParser parse) {
        this.commands = listCmd.stream().collect(Collectors.toMap(ICommand::getCmd, Function.identity()));
        this.parse = parse;
    }

    public ICommand getCommand(String inputCmd) {
        return commands.get(parse.parseCmd(inputCmd));
    }
}

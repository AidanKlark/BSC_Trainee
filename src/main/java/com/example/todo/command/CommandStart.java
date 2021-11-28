package com.example.todo.command;

import com.example.todo.command.commandName.ICommand;
import com.example.todo.parse.IParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandStart implements ICommandStart {

    private final Map<String, ICommand> getCmd;
    private final IParser parse;

    @Autowired
    public CommandStart(List<ICommand> listCmd, IParser parse) {
        this.getCmd = new HashMap<>();
        for (ICommand i : listCmd)
            getCmd.put(i.getCmd(),i);

        this.parse = parse;
    }

    @Override
    public void start(String inputCmd) {
        ICommand command = getCmd.get(parse.parseCmd(inputCmd));

        if (command != null) {
            command.accept(inputCmd);
        } else {
            System.out.println("Повторите команду");
        }
    }
}

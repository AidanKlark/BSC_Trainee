package com.example.todo.command.commandName;

public interface ICommand {
    void accept(String command);
    String getCmd();
}

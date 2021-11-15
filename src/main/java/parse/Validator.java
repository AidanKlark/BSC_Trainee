package parse;

import command.commandName.*;
import lombok.extern.slf4j.Slf4j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class Validator {

    private final CommandFactory commandFactory = new CommandFactory();

    public void selection() {

        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {

            String command;

            while (!(command = scanner.readLine().trim()).equals("quit")) {
                log.debug("Пользователь ввел команду : {}", command);
                String commandInput = Service.findCommandType(command);
                commandFactory.commandType(commandInput);

                if (commandFactory.getCn() != null) {
                    commandFactory.getCn().accept(command);

                }  else {
                    System.out.print("Неправильная команда, повторите ввод: ");
                }
            }

        } catch (IOException e) {
            System.err.println("Возникла ошибка");
        }
    }
}

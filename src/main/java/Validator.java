import command.ICommand;
import command.commandName.*;
import lombok.extern.slf4j.Slf4j;
import service.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

@Slf4j
public class Validator {

    public void selection() {

        HashMap<String, ICommand> commandType = new HashMap<>();

        commandType.put("add", new Add());
        commandType.put("toggle", new Toggle());
        commandType.put("print", new Print());
        commandType.put("print all", new Print());
        commandType.put("search", new Search());
        commandType.put("edit", new Edit());
        commandType.put("delete", new Delete());

        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
            String command;

            while (!(command = scanner.readLine().trim()).equals("quit")) {
                log.debug("Пользователь ввел команду : {}", command);
                String commandInput = Service.findCommandType(command);

                if (commandType.containsKey(commandInput)) {
                    commandType.get(commandInput).execute(command);

                }  else {
                    System.out.print("Неправильная команда, повторите ввод: ");
                }
            }

        } catch (IOException e) {
            System.err.println("Возникла ошибка");
        }
    }
}

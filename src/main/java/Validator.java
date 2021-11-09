import command.commandName.*;
import lombok.extern.slf4j.Slf4j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@Slf4j
public class Validator {

    public void selection() {
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
            String command;

            while (!(command = scanner.readLine().trim()).equals("quit")) {
                log.debug("Пользователь ввел команду : {}", command);

                if (Pattern.matches("add .+", command)) {
                    new Add().execute(command);

                } else if (Pattern.matches("print|print all", command)) {
                    new Print().execute(command);

                } else if (Pattern.matches("toggle .+|delete .+", command)) {
                    new ToggleOrDelete().execute(command);

                } else if (Pattern.matches("search .+", command)) {
                    new Search().execute(command);

                } else if (Pattern.matches("edit .+", command)) {
                    new Edit().execute(command);

                } else {
                    System.out.print("Неправильная команда, повторите ввод: ");
                }
            }

        } catch (IOException e) {
            System.err.println("Возникла ошибка");
        }
    }
}

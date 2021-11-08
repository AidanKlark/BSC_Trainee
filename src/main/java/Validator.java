import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Validator {

    public void selection() {
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
            String command;

            while (!(command = scanner.readLine().trim()).equals("quit")) {

                if (Pattern.matches("add .+", command)) {
                    Commands.add(command);

                } else if (Pattern.matches("print|print all", command)) {
                    Commands.print(command);

                } else if (Pattern.matches("toggle .+|delete .+", command)) {
                    Commands.toggleOrDelete(command);

                } else if (Pattern.matches("search .+", command)) {
                    Commands.search(command);

                } else if (Pattern.matches("edit .+", command)) {
                    Commands.edit(command);

                } else {
                    System.out.print("Неправильная команда, повторите ввод: ");
                }
            }

        } catch (IOException e) {
            System.err.println("Возникла ошибка");
        }
    }
}

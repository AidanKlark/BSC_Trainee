import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
            String command;

            while (!(command = scanner.readLine()).equals("quit")) {

                if (Pattern.matches("add.+", command)) {
                    command = command.substring(4);
                    Commands.add(command);

                } else if (Pattern.matches("print|print all", command)) {
                    Commands.print(command);

                } else if (Pattern.matches("toggle.+", command)) {
                    try {
                        Commands.toggle(Integer.parseInt(command.replaceAll("\\D+", "")));

                    } catch (NumberFormatException e) {
                        System.err.println("Пожалуйста, повторите команду toddle n(n - номер задачи): ");
                    }

                } else if (Pattern.matches("delete.+", command)) {
                    try {
                        Commands.delete(Integer.parseInt(command.replaceAll("\\D+", "")));

                    } catch (NumberFormatException e) {
                        System.err.println("Пожалуйста, повторите команду delete n(n - номер задачи): ");
                    }

                } else if (Pattern.matches("search.+", command)) {
                    command = command.substring(7).trim();
                    Commands.search(command);

                } else if (Pattern.matches("edit.+", command)) {
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

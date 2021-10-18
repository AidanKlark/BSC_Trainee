import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        try (BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in))) {
            String command;

            while (!(command = scanner.readLine()).equals("quit")) {

                if (Pattern.matches("add.+", command)) {
                    command = command.substring(4);
                    Commands.add(command);

                } else if (Pattern.matches("print|print all", command)) {
                    Commands.print(command);

                } else if (Pattern.matches("toggle.+", command)) {
                    Commands.toggle(Integer.parseInt(command.replaceAll("\\D+", "")));

                } else {
                    System.out.print("Неправильная команда, повторите ввод: ");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

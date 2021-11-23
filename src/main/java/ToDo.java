import IO.ErrorPrint;
import IO.IErrorPrint;
import command.CommandStart;
import command.ICommandStart;
import command.commandName.CommandFactory;
import lombok.extern.slf4j.Slf4j;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class ToDo {

    public static void main(String[] args) {

        log.info("Запуск программы");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CommandFactory commandFactory = new CommandFactory();
        CommandStart cmdStart = new CommandStart(commandFactory);
        IErrorPrint errPrint = ErrorPrint.getInstance();

        while (true) {
            try {
                cmdStart.start(bufferedReader.readLine());
            } catch (IOException e) {
                errPrint.printErrEx("", e);
            }
        }
    }
}

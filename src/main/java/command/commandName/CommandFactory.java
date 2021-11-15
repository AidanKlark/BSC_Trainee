package command.commandName;

import lombok.Getter;
import java.util.function.Consumer;

public class CommandFactory {

    @Getter
    private Consumer<String> cn;

    public void commandType(String command) {

        switch (command) {
            case ("add") -> cn = new Add();
            case ("search") -> cn = new Search();
            case ("delete") -> cn = new Delete();
            case ("edit") -> cn = new Edit();
            case ("toggle") -> cn = new Toggle();
            case ("print") -> cn = new Print();
        }
    }
}

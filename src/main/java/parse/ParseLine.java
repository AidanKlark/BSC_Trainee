package parse;

public interface ParseLine {
    String ERROR_NUMBER = "Введите число после команды";

    default int parseId(String command) {
        int id = 0;

        try {
            id = Integer.parseInt(command.split(" ") [1]);

        } catch (NumberFormatException nonNumber) {
            System.err.println(ERROR_NUMBER);
        }
        return id;
    }

    default String parseArgs(String command) {
        return command.split(" ") [1];
    }

    void parseIdArgs (String command);
}



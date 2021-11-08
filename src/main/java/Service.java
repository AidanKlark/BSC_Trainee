public class Service {
    private static final String ERROR_NUMBER = "Введите число после команды";

    public static int findId(String commands) {
        int id = 0;

        try {
            id = Integer.parseInt(commands.split(" ") [1]);
        } catch (NumberFormatException nonNumber) {
            System.err.println(ERROR_NUMBER);
        }
        return id;
    }
}

public class Commands {
    private static boolean status;
    private static String task;
    private final static int ID = 1;

    private static String statusCheck() {
        String check;
        check = status ? "[X]" : "[ ]";

        return check;
    }

    public static void add(String a) {

        if (!a.trim().isEmpty()) {
            task = a.trim();
            status = false;
        }
    }

    public static void print(String b) {

        if (b.equals("print") && !status && task !=null) {
            System.out.printf("%d. %s %s\n", ID, statusCheck(), task);
        }

        if (b.equals("print all") && task != null) {
            System.out.printf("%d. %s %s\n", ID, statusCheck(), task);
        }
    }

    public static void toggle(int args) {
        status = !status;
    }
}

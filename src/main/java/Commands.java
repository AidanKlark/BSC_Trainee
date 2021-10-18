public class Commands {
    private static boolean status;
    private static String task;
    private final static int ID = 1;


    public static void add(String a) {
        task = a;
        status = false;
    }

    public static void print(String b) {

        if (b.equals("print") && !status && task !=null) {
            System.out.printf("%d. [ ] %s\n", ID, task);
        }

        if (b.equals("print all") && task != null) {
            System.out.printf("%d. [%s] %s\n", ID, status ? "X" : "", task);
        }
    }

    public static void toggle(int args) {
        status = !status;
    }
}

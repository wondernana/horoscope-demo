package dbproject;


import java.util.Locale;

public class Main {

    private static final String LOGIN = "L";
    private static final String MOCK = "M";
    private static final String REGISTER = "R";
    private static final String TERMINATE = "T";


    public static User currentUser = new User();

    public static void main(String[] args) {
        boolean isInputValid = false;
        String input;
        do {
            System.out.println("Type [L] to login, [R] to register or [T] to terminate:");
            input = Reader.readLine().toUpperCase(Locale.ROOT);
            switch (input) {
                case (LOGIN):
                    isInputValid = true;
                    currentUser.login();
                    break;
                case (REGISTER):
                    isInputValid = true;
                    currentUser.register();
                    break;
                case (TERMINATE):
                    isInputValid = true;
                    break;
                // мок для работы без доступа к БД
                case (MOCK):
                    isInputValid = true;
                    currentUser.mock();
                    break;
                default: System.out.println("Unsupported input: you have to type either [L], [R] or [T].\n");
            }
        } while (!isInputValid || !input.equals(TERMINATE));
        Reader.close();
        DBConnection.close();
    }
}

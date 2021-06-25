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
//        while (!isInputValid) {
//            System.out.println("Type [L] to login, [R] to register or [T] to terminate:\n");

//              try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
//              ) {
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
                case (MOCK):
                    isInputValid = true;
                    currentUser.mock();
                    break;
                default: System.out.println("Unsupported input: you have to type either [L], [R] or [T].\n");
            }
        } while (!isInputValid || !input.equals(TERMINATE));
//            if (input.equalsIgnoreCase("L")) {
//                isInputValid = true;
//                currentUser.login();
//            } else if (input.equalsIgnoreCase("R")) {
//                isInputValid = true;
//                currentUser.register();
//            } else if (input.equalsIgnoreCase("M")) {
//                isInputValid = true;
//                User Mock = new User();
//                // System.out.println("Welcome " + u.getLogin() + "! " + Mock.getZodiac() + ' ' + Mock.showPrediction);
//            } else System.out.println("You have to type either [L] or [R]!");
//              } catch (
//          IOException e) {
//              e.printStackTrace();
//              }
//          }
//
//        }
        Reader.close();
        DBConnection.close();
    }
}

package dbproject;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class Base {

    public String processUserInput(String param) {
        boolean isValid = false;
        String input = null;
        while (!isValid) {
            System.out.println("Enter your " + param + ":");
            input = Reader.readLine(); //reader.readLine();
            if (!input.isBlank()) {
                isValid = true;
            } else {
                System.out.println(param + " should contain at least 1 character!");
            }

        } return input;

        }

    public MonthDay processDateInput() {
        MonthDay date = null;
        //Reader reader = new Reader();
        do {
//            try {
//                try (BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(System.in))
//                ) {
                    System.out.println("Enter your date of birth in DD.MM format: ");
                    date = parseDate(Reader.readLine());
                    System.out.println(date);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        } while (date == null);
        return date;
    }

    public MonthDay parseDate(String input) {
        MonthDay result = null;
        if (!input.matches("\\d{2}.\\d{2}")) {
            System.out.println("Incorrect date. Please, enter your date of birth in DD.MM format.");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");
            MonthDay date = MonthDay.parse(input, formatter);
            System.out.println(date);
            result = date;
        }
        return result;
    }
}

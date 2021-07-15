package dbproject;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Base {

    public String processUserInput(String param) {
        boolean isValid = false;
        String input = null;
        while (!isValid) {
            System.out.println("Enter your " + param + ":");
            input = Reader.readLine();
            if (!input.isBlank()) {
                isValid = true;
            } else {
                System.out.println(param + " should contain at least 1 character!");
            }

        } return input;

        }

    public MonthDay processDateInput() {
        MonthDay date = null;
        do {
            System.out.println("Enter your date of birth in DD.MM format: ");
            date = parseDate(Reader.readLine());
        } while (date == null);
        return date;
    }

    public MonthDay parseDate(String input) {
        MonthDay result = null;
        if (!input.matches("\\d{2}.\\d{2}")) {
            System.out.println("Incorrect date. Please, enter your date of birth in DD.MM format.");
        } else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");
                MonthDay date = MonthDay.parse(input, formatter);
                result = date;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date. Please, enter your date of birth in DD.MM format.");
            }
        }
        return result;
    }
}

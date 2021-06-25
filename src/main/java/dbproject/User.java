package dbproject;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class User extends Base {
    private String login;
    private String password;
    private MonthDay birthday;
    private ZodiacSigns zodiac;

    // конструктор по умолчанию
    public User() { }

    // читерский конструктор для тестирования
    User(String login, String password, MonthDay birthday) {
        this.login = login;
        this.password = password;
        this.birthday = birthday;
    }

   public void calculateZodiacSign() {
       System.out.println(getBirthday());
        MonthDay bd = getBirthday();
        if (bd.isAfter(MonthDay.of(1,20)) && (bd.isBefore(MonthDay.of(2,19)))) {
            setZodiacSign(ZodiacSigns.AQUARIUS);
       } else if (bd.isAfter(MonthDay.of(2,18)) && (bd.isBefore(MonthDay.of(3,21)))) {
            setZodiacSign(ZodiacSigns.PISCES);
        } else if (bd.isAfter(MonthDay.of(3,20)) && (bd.isBefore(MonthDay.of(4,21)))) {
            setZodiacSign(ZodiacSigns.ARIES);
        } else if (bd.isAfter(MonthDay.of(4,20)) && (bd.isBefore(MonthDay.of(5,21)))) {
            setZodiacSign(ZodiacSigns.TAURUS);
        } else if (bd.isAfter(MonthDay.of(5,20)) && (bd.isBefore(MonthDay.of(6,22)))) {
            setZodiacSign(ZodiacSigns.GEMINI);
        } else if (bd.isAfter(MonthDay.of(6,21)) && (bd.isBefore(MonthDay.of(7,23)))) {
            setZodiacSign(ZodiacSigns.CANCER);
        } else if (bd.isAfter(MonthDay.of(7,22)) && (bd.isBefore(MonthDay.of(8,24)))) {
            setZodiacSign(ZodiacSigns.LEO);
        } else if (bd.isAfter(MonthDay.of(8,23)) && (bd.isBefore(MonthDay.of(9,24)))) {
            setZodiacSign(ZodiacSigns.VIRGO);
        } else if (bd.isAfter(MonthDay.of(9,23)) && (bd.isBefore(MonthDay.of(10,24)))) {
            setZodiacSign(ZodiacSigns.LIBRA);
        } else if (bd.isAfter(MonthDay.of(10,23)) && (bd.isBefore(MonthDay.of(11,23)))) {
            setZodiacSign(ZodiacSigns.SCORPIO);
        } else if (bd.isAfter(MonthDay.of(11,22)) && (bd.isBefore(MonthDay.of(12,22)))) {
            setZodiacSign(ZodiacSigns.SAGITTARIUS);
        } else if (bd.isAfter(MonthDay.of(12,21)) && (bd.isBefore(MonthDay.of(12,31)))
                ||   bd.equals(MonthDay.parse("31.12", DateTimeFormatter.ofPattern("dd.MM"))) || (bd.isBefore(MonthDay.of(1,21)))) {
            setZodiacSign(ZodiacSigns.CAPRICORN);
        }
        else System.out.println("no zodiac match");
       System.out.println(this.getZodiac());
   }


//                try {
//                  //  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//                    while (!isValid) {
//                        System.out.println("Enter your " + param + ":");
//                        input = reader.readLine();
//                        if (input.isBlank()) {
//                            System.out.println(param + " should contain at least 1 character!");
//                        } else isValid = true;
//                    }
//                    //reader.close();
//                }
//             catch (IOException e) {
//                e.printStackTrace();
//            }
//        return input;
//    }

//        while (!isValid) {
//            System.out.println("Enter your " + param + ":");
//            Scanner scanner = new Scanner(System.in);
//            input = scanner.next();
//            scanner.close();
//            if (!input.isBlank()) {
//                isValid = true;
//            } else {
//                System.out.println(param + " should contain at least 1 character!");
//            }
//        }
//        return input;
//    }


    public void register() {
     //  String param1 = "Login";
     //  String login = null;
     //  while(login == null) {
     //      login = processInitUserInput(param1);
     //  }
     //  setLogin(login);
     //  String param2 = "Password";
     //  String password = null;
        String[] params = {"Login", "Password", "Birthday"};
        for (String param : params) {
                switch (param) {
                    case ("Login"):
                        setLogin(processUserInput(param));
                        break;
                    case ("Password"):
                        setPassword(processUserInput(param));
                        break;
                    case ("Birthday"):
                        setBirthday(processDateInput());
                        calculateZodiacSign();
                        break;
                }
            } new Authorization(this).addUser();
        }

    public void login() {
        setLogin(processUserInput("Login"));
        setPassword(processUserInput("Password"));
        new Authorization(this).findUser();
    }

    // метод-заглушка, создает юзера с захардкодеными параметрами и выводит его гороскоп
    void mock() {
        User stub = new User ("Bruce Wayne", "definitelyNotABatman", MonthDay.of(2, 19));
        stub.calculateZodiacSign();
        new Authorization(stub).getWelcomeMessage();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public MonthDay getBirthday() {
        return birthday;
    }

    public void setBirthday(MonthDay birthday) {
        this.birthday = birthday;
    }

    public ZodiacSigns getZodiac() {
        return zodiac;
    }

    public void setZodiacSign(ZodiacSigns zodiac) {
        this.zodiac = zodiac;
    }



}

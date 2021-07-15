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

    // метод для вычисления знака зодиака по дню рождения
   public void calculateZodiacSign() {
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
   }

   // метод для реристрации нового юзера
    public void register() {
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

    // метод для авторизации существующего юзера
    public void login() {
        setLogin(processUserInput("Login"));
        setPassword(processUserInput("Password"));
        new Authorization(this).findUser();
    }


    // метод-заглушка, создает юзера с захардкодеными параметрами и выводит его гороскоп
    void mock() {
        User stub = new User ("Bruce Wayne", "definitelynotbatman", MonthDay.of(2, 19));
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

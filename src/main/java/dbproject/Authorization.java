package dbproject;

import java.sql.*;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;


public class Authorization {

    private User user;

    public Authorization(User user) {
        this.user = user;
    }


    // поиск существующего юзера в БД
    public void findUser() {
        String query = "SELECT * FROM users where login = ? AND password = ?";
        try {
            PreparedStatement ps = DBConnection.getConnectionInstance().prepareStatement(query);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    user.setBirthday(MonthDay.parse(rs.getDate("birthday").toString().substring(5),
                            DateTimeFormatter.ofPattern("MM-dd")));
                    user.calculateZodiacSign();
                    getWelcomeMessage();
                }
                else {
                    System.out.println("This combination of login and password does not exist!");
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    // добавление нового юзера в БД
    public void addUser() {
    String insert = "insert into users (login, password, birthday) values (?, ?, ?)";
    // приведение дня рождения к типу Date, который можно сохранить в БД через добавление дефолтного года
    // можно сделать varchar, но мне хотелось поработать с датой
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("--MM-dd-yyyy");
    LocalDate bd = LocalDate.parse(user.getBirthday().toString().concat("-1900"), dtf);
    try {
        Statement s = DBConnection.getConnectionInstance().createStatement();
        ResultSet rs = s.executeQuery("select * from users");
        while (rs.next()) {
            if (rs.getString("login").equals(user.getLogin())) {
                System.out.println("This username already exists!");
                return;
            }
        }
        PreparedStatement ps = DBConnection.getConnectionInstance().prepareStatement(insert);
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getPassword());
        ps.setDate(3, Date.valueOf(bd));
        ps.execute();
        if (ps.getUpdateCount() == 1) {
            getWelcomeMessage();
        }
        rs.close();
    } catch(SQLException e){
        e.printStackTrace();
    }
}


    // вывод гороскопа пользователя
    public void getWelcomeMessage() {
        String prediction = new Horoscope(user.getZodiac()).showPrediction();
        System.out.println("Welcome " + user.getLogin() + "! " + "\n" + "It seems like you're " +
                user.getZodiac() + ", here's your prediction:" + "\n" + prediction + "\n");

    }
}

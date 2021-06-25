package dbproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton
class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static Connection instance;

    private DBConnection() {}

    // статический блок для try-catch
    static {
        try {
            instance = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Exception occurred while connecting to database");
        }
    }

    public static Connection getConnectionInstance() throws SQLException {
        return instance;
    }


    public static void close() {
        if (instance != null) {
            try {
                instance.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection!");
                e.printStackTrace();
            }
        }
    }
}

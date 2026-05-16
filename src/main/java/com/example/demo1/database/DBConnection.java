package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
            "jdbc:mysql://localhost:3306/school_management";

     private static final String USER = "root";

    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );

                System.out.println("Database connected!");
            }

        } catch (SQLException e) {

            System.out.println("Connection failed!");
            e.printStackTrace();
        }

        return connection;
    }
    
}

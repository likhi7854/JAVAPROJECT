package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static String url = "jdbc:mysql://localhost:3306/ecommerce_db";
    private static String password = "Ammu@nani03";
    private static String username = "root";
    public static Connection getConnection () throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}

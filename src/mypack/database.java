package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database 
{
    public Connection connection = null;
    public Statement statement = null; 

    public database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = System.getenv().getOrDefault(
                    "BANK_DB_URL", "jdbc:mysql://localhost:3307/bank");
            String user = System.getenv().getOrDefault("BANK_DB_USER", "root");
            String password = System.getenv("BANK_DB_PASSWORD");
            if (password == null || password.isBlank()) {
                throw new IllegalStateException(
                        "BANK_DB_PASSWORD environment variable is required");
            }
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.err.println("Database Initialization Failed!");
            e.printStackTrace();
        }
    }
}

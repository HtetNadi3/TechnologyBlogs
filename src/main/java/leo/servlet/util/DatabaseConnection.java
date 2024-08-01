package leo.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import leo.servlet.config.ConfigLoader;
import leo.servlet.config.DatabaseConfig;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private static final DatabaseConfig config = ConfigLoader.getDatabaseConfig();

    private DatabaseConnection() {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

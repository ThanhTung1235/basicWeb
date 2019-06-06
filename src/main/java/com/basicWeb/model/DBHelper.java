package com.basicWeb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static Connection connection;
    private static final String DB_NAME = "product-manager";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME + "?user=" + DB_USER + "&password=" + DB_PASSWORD + "");
        }
        return connection;
    }
}

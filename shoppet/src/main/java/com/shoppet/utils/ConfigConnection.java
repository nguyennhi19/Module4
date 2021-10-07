package com.shoppet.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigConnection {
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/shoppetmap";
        String jdbcUsername = "root";
        String jdbcPassword = "Nhi09092018";

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}


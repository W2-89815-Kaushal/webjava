package com.sunbeam.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/sunbeam";
    public static final String DB_USER = "dmc";
    public static final String DB_PASSWORD = "dmc";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}

package com.adelacebal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:~/Desktop/lessons/JDBC/TestDB/testjava.db");
        } catch(SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}

package com.adelacebal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:../TestDB/testjava.db");
//            Statement statement = conn.createStatement();) {
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:../TestDB/testjava.db");
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                                   "(name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                                   "VALUES('Joe', 3056689112, 'joe@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                                   "VALUES('James', 305315552, 'james@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                                   "VALUES('Valeria', 3058622267, 'valeria@email.com')");

            statement.execute("UPDATE contacts SET phone = 7863332255 WHERE name = 'Valeria'");
            statement.execute("DELETE FROM contacts WHERE name = 'James'");

            statement.close();
            conn.close();

        } catch(SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}

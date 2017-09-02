package com.adelacebal;

import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:../TestDB/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:../TestDB/testjava.db");
//            Statement statement = conn.createStatement();) {
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS" + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                                   "(" + COLUMN_NAME + "TEXT,"
                                    + COLUMN_PHONE + "INTEGER,"
                                    + COLUMN_EMAIL + "TEXT)");
            statement.execute("INSERT INTO " + TABLE_CONTACTS + "(" + COLUMN_NAME + ", "
                                + COLUMN_PHONE + ", " + COLUMN_EMAIL + ")" + "VALUES('Adel', 786365, adel@mail.com)");
            statement.execute("INSERT INTO " + TABLE_CONTACTS + "(" + COLUMN_NAME + ", "
                                + COLUMN_PHONE + ", " + COLUMN_EMAIL + ")" + "VALUES('Tim', 786468, tim@mail.com)");
            statement.execute("INSERT INTO " + TABLE_CONTACTS + "(" + COLUMN_NAME + ", "
                                + COLUMN_PHONE + ", " + COLUMN_EMAIL + ")" + "VALUES('Joe', 786836, joe@mail.com)");

            statement.execute("UPDATE" + TABLE_CONTACTS + "SET" +
                                COLUMN_PHONE + "=786123" + "WHERE" + COLUMN_NAME + "= Tim");
            statement.execute("DELETE FROM " + TABLE_CONTACTS +
                                "WHERE " + COLUMN_NAME + "=Joe");

            ResultSet results = statement.executeQuery("SELECT * FROM" + TABLE_CONTACTS);
            while(results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                                   results.getString(COLUMN_PHONE) + " " +
                                   results.getString(COLUMN_EMAIL));
            }

            results.close();

            statement.close();
            conn.close();

        } catch(SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}

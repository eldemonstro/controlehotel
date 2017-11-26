/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.eldemonstro.controlehotel.db;

import java.sql.*;

/**
 *
 * @author demon
 */
public class DBConnect {

    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:3306/";
    private String dbName = "ControleHotel";
    private String userName = "root";
    private String password = "admin";
    private String userPass = "?user=" + userName + "&password=" + password;

    private PreparedStatement statement;
    private ResultSet result;
    private Connection con;

    public DBConnect() {

        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            createDatabase();
        } finally {
           System.out.println("Successfully Connected");
        }
    }

    private void createDatabase() {
        try {
            System.out.println("Trying to make the database");
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + userPass);
            Statement s = con.createStatement();
            int myResult = s.executeUpdate("CREATE DATABASE " + dbName);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.eldemonstro.controlehotel.dao;

import io.github.eldemonstro.controlehotel.db.DBConnect;
import io.github.eldemonstro.controlehotel.models.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author demon
 */
public class PersonDao {
    private final Connection conn;
    private final String tableName = "people";

    public Connection getConn() {
        return conn;
    }

    public String getTableName() {
        return tableName;
    }
    
    public PersonDao() throws SQLException {
        DBConnect dbConnect = new DBConnect();
        this.conn = dbConnect.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
            + "  (id            INT NOT NULL AUTO_INCREMENT,"
            + "   cpf           VARCHAR(50),"
            + "   name          VARCHAR(50),"
            + "   PRIMARY KEY   (id))";

        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }
    
    public Person getByCPF(String cpf) throws SQLException {
        Person person = new Person();
        String query = "select * from " + tableName + " where cpf = " + cpf;
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                person.setId(rs.getLong(1));
                person.setCPF(rs.getString(2));
                person.setName(rs.getString(3));
            }
            rs.close();
        }
        return person;
    }

    public Person insertPerson(Person personIn) throws SQLException {
        String query = "insert into people (name, cpf) values (?,?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, personIn.getName());
            stmt.setString(2, personIn.getCPF());
            stmt.execute();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    personIn.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            
        }
        return personIn;
    }
}

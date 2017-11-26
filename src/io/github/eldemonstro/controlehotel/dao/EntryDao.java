/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.eldemonstro.controlehotel.dao;

import io.github.eldemonstro.controlehotel.db.DBConnect;
import io.github.eldemonstro.controlehotel.models.Entry;
import io.github.eldemonstro.controlehotel.models.Person;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author demon
 */
public class EntryDao {
    private final Connection conn;
    private final String tableName = "entries";

    public Connection getConn() {
        return conn;
    }

    public String getTableName() {
        return tableName;
    }
    
    public EntryDao() throws SQLException {
        DBConnect dbConnect = new DBConnect();
        this.conn = dbConnect.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName
            + "  (id            INT NOT NULL AUTO_INCREMENT,"
            + "   entry_date    VARCHAR(50),"
            + "   people_id     INT NOT NULL,"
            + "   INDEX fk_entries_people_idx (people_id ASC),"
            + "   CONSTRAINT fk_entries_people" 
            + "    FOREIGN KEY (people_id)"
            + "    REFERENCES people (id)"
            + "    ON DELETE NO ACTION"
            + "    ON UPDATE NO ACTION,"
            + "   PRIMARY KEY   (id))";

        Statement stmt = conn.createStatement();
        stmt.execute(sqlCreate);
    }
    
    public Entry saveEntry(Person person){
        Entry entry = new Entry();
        entry.setPersonId(person.getId());
        
        return entry;
    }
}

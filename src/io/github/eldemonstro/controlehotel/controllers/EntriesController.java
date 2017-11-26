/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.eldemonstro.controlehotel.controllers;

import io.github.eldemonstro.controlehotel.dao.EntryDao;
import io.github.eldemonstro.controlehotel.models.*;
import java.sql.SQLException;

/**
 *
 * @author demon
 */
public class EntriesController {
    EntryDao entryDao;
    
    public EntriesController() throws SQLException{
        entryDao = new EntryDao();
    }
    
    public Entry saveEntry(Person person) {
        Entry entry;
        entry = entryDao.saveEntry(person);
        return entry;
    }
}

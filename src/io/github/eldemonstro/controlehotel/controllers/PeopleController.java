/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.eldemonstro.controlehotel.controllers;

import io.github.eldemonstro.controlehotel.dao.PersonDao;
import io.github.eldemonstro.controlehotel.models.Person;
import java.sql.SQLException;


/**
 *
 * @author demon
 */
public class PeopleController {
    PersonDao personDao;
    
    public PeopleController() throws SQLException{
        personDao = new PersonDao();
    }
    
    public Person getByCPF(String CPF) throws SQLException {
        Person person = personDao.getByCPF(CPF);
        return person;
    }
    
    public Person insertPerson(Person personIn) throws SQLException {
        Person person = personDao.insertPerson(personIn);
        return person;
    }
}

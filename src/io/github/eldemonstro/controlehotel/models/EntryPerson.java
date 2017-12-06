/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.eldemonstro.controlehotel.models;

/**
 *
 * @author demon
 */
public class EntryPerson {
    private Person person;
    private Entry entry;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
    
    public EntryPerson(Entry entry, Person person) {
        this.entry = entry;
        this.person = person;
    }
}

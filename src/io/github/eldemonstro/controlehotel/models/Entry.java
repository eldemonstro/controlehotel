/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.eldemonstro.controlehotel.models;

import java.sql.Date;

/**
 *
 * @author demon
 */
public class Entry {
    private long id;
    private Date entryDate;
    private long person_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public long getPersonId() {
        return person_id;
    }

    public void setPersonId(long person_id) {
        this.person_id = person_id;
    }
}

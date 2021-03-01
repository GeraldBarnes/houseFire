/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.entities;


import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.nio.file.Path;


/**
 *
 * @author admin
 */
@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer ID;
    
    String firstName;
    
    String lastName;
    
    String password;
    
    String about;
    
    String email;
    
    Timestamp created;
    
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getPassword() {
        return password;
    }

    public String getAbout() {
        return about;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "PersonEntity{" + "ID=" + ID + ", FIRSTNAME=" + firstName + ", LASTNAME=" + lastName + ", ABOUT=" + about + ", EMAIL=" + email + ", CREATED=" + created + '}';
    }
    
}

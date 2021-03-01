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

/**
 *
 * @author admin
 */
@Entity
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer ID; 

    String blurb;
    
    Timestamp postDate;
   
    Integer personID;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public Integer getID() {
        return ID;
    }

    public String getBlurb() {
        return blurb;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public Integer getPersonID() {
        return personID;
    }
    @Override
    public String toString() {
        return "MessageEntity [id=" + ID + ", blurb=" + blurb + 
                ", postDate=" + postDate + ", person_id=" + personID   + "]";
    }
}

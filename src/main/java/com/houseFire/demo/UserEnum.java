/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo;

import com.houseFire.demo.entities.PersonEntity;

/**
 *
 * @author admin
 */
public final class UserEnum {
    
    private static UserEnum INSTANCE; 
 
    private PersonEntity user;
 
    private UserEnum() {
    }
 
    public static UserEnum getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserEnum();
        }
        return INSTANCE;
    }
    
    public PersonEntity getUser() {
        return user;
    }
    
    public void setUser(PersonEntity user) {
        this.user = user;
    }
    
}

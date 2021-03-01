/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.controllers;

import com.houseFire.demo.Interface.PersonRepository;
import com.houseFire.demo.entities.PersonEntity;
import com.houseFire.demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author admin
 */
@Controller
public class PersonController{   
    @Autowired
    private PersonRepository repository;
    @Autowired
    PersonServiceImpl personServiceImpl;
    @PostMapping(path="/signup")
    public String PersonController(@ModelAttribute PersonEntity personEntity) {
        repository.save(personServiceImpl.registerNewPersonAccount(personEntity));
       // login();
        return "redirect:/home";
    }
    
}

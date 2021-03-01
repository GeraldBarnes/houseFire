/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.service;

import com.houseFire.demo.Interface.PersonRepository;
import com.houseFire.demo.Interface.PersonService;
import com.houseFire.demo.entities.PersonEntity;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
 *
 * @author admin
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository repository;
            
  public PersonEntity registerNewPersonAccount(PersonEntity person){
      PersonEntity newUser = new PersonEntity();
      newUser.setFirstName(person.getFirstName());
      newUser.setLastName(person.getLastName());
      Date date = new Date();
      newUser.setCreated(new Timestamp(date.getTime()));
      newUser.setPassword(person.getPassword());
      newUser.setEmail(person.getEmail());
      
      return newUser;
  }
  
  public boolean checkPersonExistsByEmail(String email){
      return repository.existsByEmail(email);      
  }
  
  public PersonEntity getPersonByEmail(String email){
      return repository.findPersonByEmail(email);   
  }
  
  public void savePerson(PersonEntity user){
      repository.save(user);   
  }
  
  public PersonEntity setPersonFromEmailOidcUser(OidcUser user){
      PersonEntity mainUser = new PersonEntity();
      mainUser.setEmail(user.getEmail());
      mainUser.setFirstName(user.getGivenName()); 
      mainUser.setLastName(user.getFamilyName());
      Date date = new Date();
      mainUser.setCreated(new Timestamp(date.getTime()));
      return mainUser;
  }
  
//     @Bean 
//    public PasswordEncoder passwordEncoder() { 
//        return new PasswordEncoder(); 
//    }
}

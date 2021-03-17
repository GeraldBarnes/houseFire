/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.controllers;



import com.houseFire.demo.Interface.MessageRepository;
import com.houseFire.demo.UserEnum;
import com.houseFire.demo.entities.MessageEntity;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author admin
 */
@Controller
public class MessageController {
    
   
  @Autowired
  private MessageRepository repository;  
  
    @PostMapping(path="/message") // Map ONLY POST Requests
  public String addNewMessage (@ModelAttribute MessageEntity message,@AuthenticationPrincipal OidcUser user
      //, @RequestParam Date date
          ) {
    UserEnum userEnum = UserEnum.getInstance();
    
    message.setPersonID(userEnum.getUser().getID());
    Date date = new Date();
    message.setPostDate(new Timestamp(date.getTime()));
    repository.save(message);
    return "redirect:/home";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<MessageEntity> getAllMessages() {
    // This returns a JSON or XML with the users
    return repository.findAll();
  }
    
}

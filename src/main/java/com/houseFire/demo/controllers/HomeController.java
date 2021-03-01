/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.controllers;



import com.houseFire.demo.UserEnum;
import com.houseFire.demo.entities.MessageEntity;
import com.houseFire.demo.entities.PersonEntity;
import com.houseFire.demo.service.MessageServiceImpl;
import com.houseFire.demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author admin
 */

@Controller
public class HomeController {
    @Autowired
    MessageServiceImpl messageService;
    @Autowired
    PersonServiceImpl personService;
    
        @RequestMapping(value = {"/home","/"})
        public String home(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,  
                              @AuthenticationPrincipal OAuth2User oauth2User, @AuthenticationPrincipal OidcUser user) {
            PersonEntity mainUser;
            if(personService.checkPersonExistsByEmail(user.getEmail())){
                mainUser = personService.getPersonByEmail(user.getEmail());
            }else{
                mainUser = personService.setPersonFromEmailOidcUser(user);
                personService.savePerson(mainUser);
            }
            UserEnum userEnum = UserEnum.getInstance();
            userEnum.setUser(mainUser);
            model.addAttribute("user", mainUser);
            model.addAttribute("messages", messageService.listAllById(mainUser.getID()));
            model.addAttribute("messageEntity", new MessageEntity());
                return "home";
        }
        
        
        
}

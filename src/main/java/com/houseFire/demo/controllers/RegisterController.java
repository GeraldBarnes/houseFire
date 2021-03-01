package com.houseFire.demo.controllers;

import com.houseFire.demo.entities.PersonEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegisterController {
    
    @RequestMapping(value = "/register")
    public String RegisterController(Model model) {
        model.addAttribute("personEntity", new PersonEntity());
        return "register";
    }


}

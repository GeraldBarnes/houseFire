/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.controllers;

import com.houseFire.demo.UserEnum;
import com.houseFire.demo.service.PersonServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class UploadController {
    @Autowired
    PersonServiceImpl personService;
    private final String UPLOAD_DIR = "./uploads/";

//    @GetMapping("/")
//    public String homepage() {
//        return "home";
//    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            
            //**Absolute path is C:\Program Files\Apache Software Foundation\Tomcat 9.0\bin\toraco.jpeg
            //**
            //Path pathToFile = Paths.get(fileName);
            //System.out.println(pathToFile.toAbsolutePath());
            
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            UserEnum userEnum = UserEnum.getInstance();
            System.out.println(path.toString());
            userEnum.getUser().setPath(path.toString());
            personService.savePerson(userEnum.getUser());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.controllers;

import com.houseFire.demo.UserEnum;
import com.houseFire.demo.entities.PersonEntity;
import com.houseFire.demo.service.FileUploadUtil;
import com.houseFire.demo.service.PersonServiceImpl;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class UploadController {
    @Autowired
    PersonServiceImpl personService;
    private final String UPLOAD_DIR = "./uploads/";


    @PostMapping("/upload")
    public String uploadFile(PersonEntity user, @RequestParam("image") MultipartFile file, RedirectAttributes attributes) throws IOException {

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        UserEnum userEnum = UserEnum.getInstance();
        user = userEnum.getUser();
        user.setPhotoPath(fileName);
        personService.savePerson(user);
        String uploadDir = "user-photos/" + user.getID();
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        return "redirect:/";
    }

}

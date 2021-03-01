/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.houseFire.demo.service;

import com.houseFire.demo.Interface.MessageRepository;
import com.houseFire.demo.Interface.MessageService;
import com.houseFire.demo.entities.MessageEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
  private MessageRepository repository;
    
    public List<MessageEntity> listAll() {
    List<MessageEntity> messageEntitys = new ArrayList<>();
    repository.findAll().forEach(messageEntitys::add);
    Collections.reverse(messageEntitys);
    return messageEntitys;
    }
    
    public List<MessageEntity> listAllById(Integer id) {
    List<MessageEntity> messageEntitys = new ArrayList<>();
    repository.getMessagesByPersonID(id).forEach(messageEntitys::add);
    Collections.reverse(messageEntitys);
    return messageEntitys;
    }
}

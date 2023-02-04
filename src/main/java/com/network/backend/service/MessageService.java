package com.network.backend.service;

import com.network.backend.model.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Transactional
    public Message saveMessage(Message message){
        return message;
    }

    @Transactional
    public Message getMessage(long id){
        return null;
    }

    @Transactional
    public Message updateMessage(Message message){
        return message;
    }

    @Transactional
    public void deleteMessage(long id){

    }

    @Transactional
    public List<Message> getMassagesByUserId(long id){
        return null;
    }

}

package com.network.backend.service;

import com.network.backend.facade.MessageFasad;
import com.network.backend.dto.message.MessageDTOForCreate;
import com.network.backend.dto.message.MessageDTOForRead;
import com.network.backend.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MessageService {


    private MessageFasad messageFasad=new MessageFasad();

//    @Autowired
//    public MessageService(@Qualifier("messageFasad") MessageFasad messageFasad) {
//        this.messageFasad = messageFasad;
//    }

    @Transactional
    public Message saveMessage(Message message){
        return null;
    }

    @Transactional
    public Message getMessage(long id){
        return null;
    }

    @Transactional
    public Message updateMessage(Message message){
        return null;
    }

    @Transactional
    public boolean deleteMessage(long id){
        return true;
    }

    @Transactional
    public List<Message> getMassagesByUserId(long id){
        return null;
    }

}

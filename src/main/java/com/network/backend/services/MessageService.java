package com.network.backend.services;

import com.network.backend.fasad.MessageFasad;
import com.network.backend.fasad.dto.messages.MessageDTOForCreate;
import com.network.backend.fasad.dto.messages.MessageDTOForRead;
import com.network.backend.models.Message;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MessageService {

    private MessageFasad messageFasad=new MessageFasad();

    @Transactional
    public void saveMessage(MessageDTOForCreate dto){
        Message message=messageFasad.getEntityByCreateMessageDTO(dto);
    }

    @Transactional
    public Message getMessage(long id){
        return null;
    }

    @Transactional
    public void updateMessage(MessageDTOForRead dto){
        Message message= messageFasad.getEntityByReadOrUpdateMessageDTO(dto);
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

package com.network.backend.facade;

import com.network.backend.dto.message.MessageDTOForCreate;
import com.network.backend.dto.message.MessageDTOForRead;
import com.network.backend.exception.NoSuchMessage;
import com.network.backend.model.Message;
import com.network.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageFacade {

    private MessageService messageService;
    @Autowired
    public MessageFacade(@Qualifier("messageService") MessageService messageService) {
        this.messageService = messageService;
    }

    public MessageDTOForCreate createMessage(MessageDTOForCreate message){
        Message message1=messageService.saveMessage(getEntityByCreateMessageDTO(message));
        return createMessageDTO(message1);
    }

    private Message getEntityByCreateMessageDTO(MessageDTOForCreate message){
        Message temp=message.getEntity();
        return temp;
    }

    public MessageDTOForCreate createMessageDTO(Message message){
        MessageDTOForCreate messageDTOForCreate=new MessageDTOForCreate(message);
        return messageDTOForCreate;
    }


    public MessageDTOForRead readMessage(long id){
        Message message=messageService.getMessage(id);
        if (message==null) throw new NoSuchMessage("No such message with id "+id);
        return readOrUpdateMessageDTO(message);
    }

    public MessageDTOForRead updateMessage(MessageDTOForRead message){
        Message message1=messageService.updateMessage(getEntityByReadOrUpdateMessageDTO(message));
        return readOrUpdateMessageDTO(message1);
    }

    public boolean deleteMessage(long id){
        if(messageService.getMessage(id)==null) throw new NoSuchMessage("No such message with id "+id);
        messageService.deleteMessage(id);
        return true;
    }

    public MessageDTOForRead readOrUpdateMessageDTO(Message message){
        MessageDTOForRead messageDTOForRead=new MessageDTOForRead(message);
        return messageDTOForRead;
    }

    public Message getEntityByReadOrUpdateMessageDTO(MessageDTOForRead message){
        Message temp=message.getEntity();
        return temp;
    }


    public List<Message> getAllMessageByUserId(long id){
        return messageService.getMassagesByUserId(id);
    }


}

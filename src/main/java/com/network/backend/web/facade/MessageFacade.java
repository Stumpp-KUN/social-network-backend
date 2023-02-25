package com.network.backend.web.facade;

import com.network.backend.web.dto.message.MessageDTOForCreate;
import com.network.backend.web.dto.message.MessageDTOForRead;
import com.network.backend.model.exception.NoSuchMessage;
import com.network.backend.model.Message;
import com.network.backend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MessageFacade {

    private final MessageService messageService;
    private final UserFacade userFacade;

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
        return readOrUpdateMessageDTO(message);
    }

    public MessageDTOForRead getReadDTObyEntity(Message message){
        MessageDTOForRead messageDTOForRead=new MessageDTOForRead(message);
        return messageDTOForRead;
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


    public Page<Message> getAllMessageByUserId(long id, Integer pageNo, Integer pageSize, String sortBy){
        return messageService.getMassagesByUserId(userFacade.getUserDTORead(userFacade.readUser(id)),pageNo,pageSize,sortBy);
    }


}

package com.network.backend.fasad;

import com.network.backend.fasad.dto.messages.MessageDTOForCreate;
import com.network.backend.fasad.dto.messages.MessageDTOForRead;
import com.network.backend.models.Message;

public class MessageFasad {
    public MessageDTOForCreate createMessageDTO(Message message){
        MessageDTOForCreate messageDTOForCreate=new MessageDTOForCreate(message);
        return messageDTOForCreate;
    }

    public Message getEntityByCreateMessageDTO(MessageDTOForCreate message){
        Message temp=message.getEntity();
        return temp;
    }


    public MessageDTOForRead readOrUpdateMessageDTO(Message message){
        MessageDTOForRead messageDTOForRead=new MessageDTOForRead(message);
        return messageDTOForRead;
    }

    public Message getEntityByReadOrUpdateMessageDTO(MessageDTOForRead message){
        Message temp=message.getEntity();
        return temp;
    }
}

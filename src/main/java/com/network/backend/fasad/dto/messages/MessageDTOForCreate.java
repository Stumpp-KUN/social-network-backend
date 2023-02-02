package com.network.backend.fasad.dto.messages;

import com.network.backend.models.Message;

public class MessageDTOForCreate extends MessageDTO {
    public MessageDTOForCreate(Message entity){
        setMessage(entity.getMessage());
        setDate(entity.getDate());
        setUser1(entity.getUser1());
        setUser2(entity.getUser2());
    }

    public Message getEntity(){
        Message message=new Message();
        message.setMessage(this.getMessage());
        message.setDate(this.getDate());
        message.setUser1(this.getUser1());
        message.setUser2(this.getUser2());
        return message;
    }
}

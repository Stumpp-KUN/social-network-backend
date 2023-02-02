package com.network.backend.fasad.dto.messages;

import com.network.backend.models.Message;

// and for update
public class MessageDTOForRead extends MessageDTO{
    public MessageDTOForRead(Message entity){
        setId(entity.getId());
        setMessage(entity.getMessage());
        setDate(entity.getDate());
        setUser1(entity.getUser1());
        setUser2(entity.getUser2());
    }

    public Message getEntity(){
        Message message=new Message();
        message.setId(this.getId());
        message.setMessage(this.getMessage());
        message.setDate(this.getDate());
        message.setUser1(this.getUser1());
        message.setUser2(this.getUser2());
        return message;
    }
}

package com.network.backend.dto.message;

import com.network.backend.model.Message;

// and for update
public class MessageDTOForRead extends MessageDTO{
    public MessageDTOForRead(Message entity){
        setId(entity.getId());
        setMessage(entity.getMessage());
        setDate(entity.getDate());
        setUser1(entity.getSender());
        setUser2(entity.getReceiver());
    }

    public Message getEntity(){
        Message message=new Message();
        message.setId(this.getId());
        message.setMessage(this.getMessage());
        message.setDate(this.getDate());
        message.setSender(this.getUser1());
        message.setReceiver(this.getUser2());
        return message;
    }
}

package com.network.backend.dto.message;

import com.network.backend.model.Message;

public class MessageDTOForCreate extends MessageDTO {
    public MessageDTOForCreate(Message entity){
        setMessage(entity.getMessage());
        setDate(entity.getDate());
        setUser1(entity.getSender());
        setUser2(entity.getReceiver());
    }

    public Message getEntity(){
        Message message=new Message();
        message.setMessage(this.getMessage());
        message.setDate(this.getDate());
        message.setSender(this.getUser1());
        message.setReceiver(this.getUser2());
        return message;
    }
}

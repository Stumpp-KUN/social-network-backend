package com.network.backend.dto.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Message;
import com.network.backend.model.User;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class MessageDTOForCreate extends MessageDTO {
    @ConstructorProperties({"message","time","sender_id","receiver_id"})
    public MessageDTOForCreate(String message, LocalDateTime date, User sender,User receiver){
        setMessage(message);
        setDate(date);
        setUser1(sender);
        setUser2(receiver);
    }

    public MessageDTOForCreate(Message entity){
        setMessage(entity.getMessage());
        setDate(entity.getDate());
        setUser1(entity.getSender());
        setUser2(entity.getReceiver());
    }

    @JsonIgnore
    public Message getEntity(){
        Message message=new Message();
        message.setMessage(this.getMessage());
        message.setDate(this.getDate());
        message.setSender(this.getUser1());
        message.setReceiver(this.getUser2());
        return message;
    }
}

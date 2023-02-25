package com.network.backend.web.dto.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Message;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

public class MessageDTOForCreate extends MessageDTO {
    @ConstructorProperties({"message","time","sender_id","receiver_id"})
    public MessageDTOForCreate(String message, LocalDateTime date, Users sender, Users receiver){
        setMessage(message);
        setDate(date);
        setUsers1(sender);
        setUsers2(receiver);
    }

    public MessageDTOForCreate(Message entity){
        setMessage(entity.getMessage());
        setDate(entity.getDate());
        setUsers1(entity.getSender());
        setUsers2(entity.getReceiver());
    }

    @JsonIgnore
    public Message getEntity(){
        Message message=new Message();
        message.setMessage(this.getMessage());
        message.setDate(this.getDate());
        message.setSender(this.getUsers1());
        message.setReceiver(this.getUsers2());
        return message;
    }
}

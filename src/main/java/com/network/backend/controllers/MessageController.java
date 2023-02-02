package com.network.backend.controllers;

import com.network.backend.exception.NoSuchMessage;
import com.network.backend.fasad.MessageFasad;
import com.network.backend.fasad.dto.messages.MessageDTOForCreate;
import com.network.backend.fasad.dto.messages.MessageDTOForRead;
import com.network.backend.models.Message;
import com.network.backend.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    //@Autowired
    private MessageService messageService=new MessageService();
    private MessageFasad messageFasad=new MessageFasad();

    @PostMapping("/messages")
    public ResponseEntity<Message> addNewMessage(@RequestBody Message message){
        messageService.saveMessage(messageFasad.createMessageDTO(message));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessage(@RequestParam long id){
        return new ResponseEntity<>(messageFasad.getEntityByReadOrUpdateMessageDTO(messageFasad.readOrUpdateMessageDTO(messageService.getMessage(id))),HttpStatus.OK);
    }

    @PutMapping("/messages")
    public ResponseEntity<Message> updateMessage(@RequestBody Message message){
        messageService.updateMessage(messageFasad.readOrUpdateMessageDTO(message));
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@RequestParam long id){
        if(messageService.getMessage(id)==null) throw new NoSuchMessage("There is not message with id "+id);
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/messages/users/{id}")
    public ResponseEntity<List<Message>> getByUserId(@RequestParam long id){
        List<Message> messages=messageService.getMassagesByUserId(id);
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }
}

package com.network.backend.controller;

import com.network.backend.dto.message.MessageDTOForCreate;
import com.network.backend.dto.message.MessageDTOForRead;
import com.network.backend.facade.MessageFacade;
import com.network.backend.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    MessageFacade messageFacade;

    @Autowired
    public MessageController(@Qualifier("messageFacade") MessageFacade messageFacade) {
        this.messageFacade = messageFacade;
    }

    @PostMapping()
    public ResponseEntity<MessageDTOForCreate> addNewMessage(@RequestBody MessageDTOForCreate message){
        return new ResponseEntity<>(messageFacade.createMessage(message), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTOForRead> getMessage(@PathVariable long id){
        return new ResponseEntity<>(messageFacade.readMessage(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MessageDTOForRead> updateMessage(@RequestBody MessageDTOForRead message){
        return new ResponseEntity<>(messageFacade.updateMessage(message),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable long id){
        messageFacade.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Message>> getByUserId(@RequestParam long id){
        return new ResponseEntity<>(messageFacade.getAllMessageByUserId(id),HttpStatus.OK);
    }
}

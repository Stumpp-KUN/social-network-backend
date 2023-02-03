package com.network.backend.controller;

import com.network.backend.dto.message.MessageDTOForCreate;
import com.network.backend.dto.message.MessageDTOForRead;
import com.network.backend.exception.NoSuchMessage;
import com.network.backend.facade.MessageFasad;
import com.network.backend.model.Message;
import com.network.backend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {


    private MessageFasad messageFasad=new MessageFasad();

//    @Autowired
//    public MessageController(@Qualifier("messageFasad") MessageFasad messageFasad) {
//        this.messageFasad = messageFasad;
//    }

    @PostMapping()
    public ResponseEntity<MessageDTOForCreate> addNewMessage(@RequestBody MessageDTOForCreate message){
        return new ResponseEntity<>(messageFasad.createMessage(message), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTOForRead> getMessage(@PathVariable long id){
        return new ResponseEntity<>(messageFasad.readMessage(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MessageDTOForRead> updateMessage(@RequestBody MessageDTOForRead message){
        return new ResponseEntity<>(messageFasad.updateMessage(message),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable long id){
        messageFasad.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Message>> getByUserId(@RequestParam long id){
        return new ResponseEntity<>(messageFasad.getAllMessageByUserId(id),HttpStatus.OK);
    }
}

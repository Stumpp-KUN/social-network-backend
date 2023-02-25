package com.network.backend.web.controller;

import com.network.backend.model.Message;
import com.network.backend.web.dto.message.MessageDTOForCreate;
import com.network.backend.web.dto.message.MessageDTOForRead;
import com.network.backend.web.facade.MessageFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageFacade messageFacade;

    @PostMapping()
    public ResponseEntity<MessageDTOForCreate> addNewMessage(@RequestBody @Valid MessageDTOForCreate message){
        return new ResponseEntity<>(messageFacade.createMessage(message), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTOForRead> getMessage(@PathVariable long id){
        return new ResponseEntity<>(messageFacade.readMessage(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<MessageDTOForRead> updateMessage(@RequestBody @Valid MessageDTOForRead message){
        return new ResponseEntity<>(messageFacade.updateMessage(message),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable long id){
        messageFacade.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Page<Message>> getByUserId(@PathVariable long id,
                                                     @RequestParam(defaultValue = "0") Integer pageNo,
                                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                                     @RequestParam(defaultValue = "id") String sortBy){
        return new ResponseEntity<>(messageFacade.getAllMessageByUserId(id,pageNo,pageSize,sortBy   ),HttpStatus.OK);
    }
}

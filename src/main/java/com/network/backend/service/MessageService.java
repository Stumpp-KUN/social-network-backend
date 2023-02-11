package com.network.backend.service;

import com.network.backend.exception.NoSuchMessage;
import com.network.backend.model.Message;
import com.network.backend.model.Subscription;
import com.network.backend.model.Users;
import com.network.backend.repository.MessageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }

    @Transactional
    public Message getMessage(long id){
        Optional<Message> message=messageRepository.findById(id);
        if(message.isEmpty())return null;
        return message.get();
    }

    @Transactional
    public Message updateMessage(Message message){
        return messageRepository.save(message);
    }

    @Transactional
    public void deleteMessage(long id){
        messageRepository.deleteById(id);
    }

    @Transactional
    public List<Message> getMassagesByUserId(Users users,Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Message> pagedResult=messageRepository.findAllBySender(users,paging);
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Message>();
        }
    }


}

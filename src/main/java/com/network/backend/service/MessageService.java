package com.network.backend.service;

import com.network.backend.exception.EntityNotFoundException;
import com.network.backend.model.Message;
import com.network.backend.model.Users;
import com.network.backend.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }

    public Message getMessage(long id){
        return messageRepository.findById(id).orElseThrow(()->new EntityNotFoundException("There is not message with id "+id));
    }

    @Transactional
    public Message updateMessage(Message message){
        return messageRepository.save(message);
    }

    @Transactional
    public void deleteMessage(long id){
        messageRepository.deleteById(id);
    }

    public Page<Message> getMassagesByUserId(Users users,Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Message> pagedResult=messageRepository.findAllBySender(users,paging);
        if(pagedResult.hasContent()) {
            return pagedResult;
        } else {
            return null;
        }
    }


}

package com.network.backend.service;

import com.network.backend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Transactional
    public User saveUser(User user){
        return user;
    }

    @Transactional
    public User getUser(long id){
        return null;
    }

    @Transactional
    public User updateUser(User user){
        return user;
    }

    @Transactional
    public void deleteUser(long id){

    }
}

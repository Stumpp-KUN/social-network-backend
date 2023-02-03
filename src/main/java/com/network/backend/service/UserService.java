package com.network.backend.service;

import com.network.backend.facade.UserFasad;
import com.network.backend.dto.user.UserDTOForCreate;
import com.network.backend.dto.user.UserDTOForUpdate;
import com.network.backend.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private UserFasad userFasad=new UserFasad();

    @Transactional
    public User saveUser(User user){
        return null;
    }

    @Transactional
    public User getUser(long id){
        return null;
    }

    @Transactional
    public User updateUser(User user){
        return null;
    }

    @Transactional
    public boolean deleteUser(long id){
        return true;
    }
}

package com.network.backend.services;

import com.network.backend.fasad.UserFasad;
import com.network.backend.fasad.dto.user.UserDTOForCreate;
import com.network.backend.fasad.dto.user.UserDTOForUpdate;
import com.network.backend.models.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    private UserFasad userFasad=new UserFasad();

    @Transactional
    public void saveUser(UserDTOForCreate user){
        User user1=userFasad.getEntityByCreateUserDTO(user);
    }

    @Transactional
    public User getUser(long id){
        return null;
    }

    @Transactional
    public void updateUser(UserDTOForUpdate user){
        User user1=userFasad.getEntityByUpdateUserDTO(user);
    }

    @Transactional
    public boolean deleteUser(long id){
        return true;
    }
}

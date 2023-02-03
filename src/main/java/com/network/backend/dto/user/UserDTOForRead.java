package com.network.backend.dto.user;

import com.network.backend.model.User;

public class UserDTOForRead extends UserDTO{
    public UserDTOForRead(User entity){
        setId(entity.getId());
        setName(entity.getName());
        setSurname(entity.getSurname());
        setEmail(entity.getEmail());
    }

    public User getEntity(){
        User user=new User();
        user.setId(this.getId());
        user.setName(this.getName());
        user.setSurname(this.getSurname());
        user.setEmail(this.getEmail());
        return user;
    }
}

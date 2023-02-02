package com.network.backend.fasad.dto.user;

import com.network.backend.models.User;

public class UserDTOForCreate extends UserDTO{
    public UserDTOForCreate(User entity){
        setName(entity.getName());
        setSurname(entity.getSurname());
        setEmail(entity.getEmail());
        setPassword(entity.getPassword());
    }

    public User getEntity(){
        User user=new User();
        user.setName(this.getName());
        user.setSurname(this.getSurname());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        return user;
    }
}

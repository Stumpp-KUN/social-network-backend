package com.network.backend.dto.user;

import com.network.backend.model.User;

import java.beans.ConstructorProperties;

public class UserDTOForRead extends UserDTO{
    @ConstructorProperties({"name", "surname","email"})
    public UserDTOForRead(String name, String surname,String email){
        setName(name);
        setSurname(surname);
        setEmail(email);
    }
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

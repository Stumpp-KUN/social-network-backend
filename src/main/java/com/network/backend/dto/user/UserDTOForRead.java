package com.network.backend.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;

public class UserDTOForRead extends UserDTO{
    @ConstructorProperties({"name", "surname","email"})
    public UserDTOForRead(String name, String surname,String email){
        setName(name);
        setSurname(surname);
        setEmail(email);
    }
    public UserDTOForRead(Users entity){
        setId(entity.getId());
        setName(entity.getName());
        setSurname(entity.getSurname());
        setEmail(entity.getEmail());
    }

    @JsonIgnore
    public Users getEntity(){
        Users users =new Users();
        users.setId(this.getId());
        users.setName(this.getName());
        users.setSurname(this.getSurname());
        users.setEmail(this.getEmail());
        return users;
    }
}

package com.network.backend.web.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Users;

import java.beans.ConstructorProperties;

public class UserDTOForCreate extends UserDTO{

    @ConstructorProperties({"name", "surname","email","password"})
    public UserDTOForCreate(String name, String surname,String email,String password){
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
    }

    public UserDTOForCreate(Users entity){
            setName(entity.getName());
            setSurname(entity.getSurname());
            setEmail(entity.getEmail());
            setPassword(entity.getPassword());
        }

    @JsonIgnore
    public Users getEntity(){
        Users users =new Users();
        users.setName(this.getName());
        users.setSurname(this.getSurname());
        users.setEmail(this.getEmail());
        users.setPassword(this.getPassword());
        return users;
    }
}

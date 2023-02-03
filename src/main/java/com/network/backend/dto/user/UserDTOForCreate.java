package com.network.backend.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.network.backend.model.User;

import java.beans.ConstructorProperties;

public class UserDTOForCreate extends UserDTO{

    @ConstructorProperties({"name", "surname","email","password"})
    public UserDTOForCreate(String name, String surname,String email,String password){
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
    }

    public UserDTOForCreate(User entity){
            setName(entity.getName());
            setSurname(entity.getSurname());
            setEmail(entity.getEmail());
            setPassword(entity.getPassword());
        }

    @JsonIgnore
    public User getEntity(){
        User user=new User();
        user.setName(this.getName());
        user.setSurname(this.getSurname());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        return user;
    }
}

package com.network.backend.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.User;

import java.beans.ConstructorProperties;

public class UserDTOForUpdate extends UserDTO{
    @ConstructorProperties({"id","name", "surname","email","password"})
    public UserDTOForUpdate(long id,String name, String surname,String email,String password){
        setId(id);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPassword(password);
    }

    public UserDTOForUpdate(User entity){
        setId(entity.getId());
        setName(entity.getName());
        setSurname(entity.getSurname());
        setEmail(entity.getEmail());
        setPassword(entity.getPassword());
    }
    @JsonIgnore
    public User getEntity(){
        User user=new User();
        user.setId(this.getId());
        user.setName(this.getName());
        user.setSurname(this.getSurname());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        return user;
    }
}

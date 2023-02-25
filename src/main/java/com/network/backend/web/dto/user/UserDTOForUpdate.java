package com.network.backend.web.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.network.backend.model.Users;

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

    public UserDTOForUpdate(Users entity){
        setId(entity.getId());
        setName(entity.getName());
        setSurname(entity.getSurname());
        setEmail(entity.getEmail());
        setPassword(entity.getPassword());
    }
    @JsonIgnore
    public Users getEntity(){
        Users users =new Users();
        users.setId(this.getId());
        users.setName(this.getName());
        users.setSurname(this.getSurname());
        users.setEmail(this.getEmail());
        users.setPassword(this.getPassword());
        return users;
    }
}

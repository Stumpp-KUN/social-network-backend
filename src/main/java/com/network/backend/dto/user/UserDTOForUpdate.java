package com.network.backend.dto.user;

import com.network.backend.model.User;

public class UserDTOForUpdate extends UserDTO{
    public UserDTOForUpdate(User entity){
        setId(entity.getId());
        setName(entity.getName());
        setSurname(entity.getSurname());
        setEmail(entity.getEmail());
        setPassword(entity.getPassword());
    }
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

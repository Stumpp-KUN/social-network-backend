package com.network.backend.fasad;

import com.network.backend.fasad.dto.user.UserDTOForCreate;
import com.network.backend.fasad.dto.user.UserDTOForRead;
import com.network.backend.fasad.dto.user.UserDTOForUpdate;
import com.network.backend.models.User;

public class UserFasad {

    public UserDTOForCreate createUserDTO(User user){
        UserDTOForCreate userDTOForCreate=new UserDTOForCreate(user);
        return userDTOForCreate;
    }

    public User getEntityByCreateUserDTO(UserDTOForCreate user){
        User temp=user.getEntity();
        return temp;
    }


    public UserDTOForRead readUserDTO(User user){
         UserDTOForRead userDTOForRead=new UserDTOForRead(user);
         return userDTOForRead;
    }

    public User getEntityByReadUserDTO(UserDTOForRead user){
        User temp=user.getEntity();
        return temp;
    }


    public UserDTOForUpdate updateUserDTO(User user){
        UserDTOForUpdate userDTOForUpdate=new UserDTOForUpdate(user);
        return userDTOForUpdate;
    }

    public User getEntityByUpdateUserDTO(UserDTOForUpdate user){
        User temp=user.getEntity();
        return temp;
    }
}

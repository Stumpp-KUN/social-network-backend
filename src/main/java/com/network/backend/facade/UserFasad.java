package com.network.backend.facade;

import com.network.backend.dto.user.UserDTOForCreate;
import com.network.backend.dto.user.UserDTOForRead;
import com.network.backend.dto.user.UserDTOForUpdate;
import com.network.backend.exception.NoSuchUser;
import com.network.backend.model.User;
import com.network.backend.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserFasad {
    private UserService userService;

    public UserFasad(UserService userService) {
        this.userService = userService;
    }

    public UserDTOForCreate createUser(UserDTOForCreate user){
        User user1=userService.saveUser(getEntityByCreateUserDTO(user));
        return createUserDTO(user1);
    }

    private User getEntityByCreateUserDTO(UserDTOForCreate user){
        User temp=user.getEntity();
        return temp;
    }

    public UserDTOForCreate createUserDTO(User user){
        UserDTOForCreate userDTOForCreate=new UserDTOForCreate(user);
        return userDTOForCreate;
    }




    public UserDTOForRead readUser(long id){
        User user=userService.getUser(id);
        if(user==null) throw new NoSuchUser("There is no user with id "+id);
        return readUserDTO(user);
    }

    private UserDTOForRead readUserDTO(User user){
         UserDTOForRead userDTOForRead=new UserDTOForRead(user);
         return userDTOForRead;
    }



    public UserDTOForUpdate updateUserDTO(UserDTOForUpdate user){
        User user1=userService.updateUser(getEntityByUpdateUserDTO(user));
        return updateUserDTO(user1);
    }

    private User getEntityByUpdateUserDTO(UserDTOForUpdate user){
        User temp=user.getEntity();
        return temp;
    }

    public UserDTOForUpdate updateUserDTO(User user){
        UserDTOForUpdate userDTOForUpdate=new UserDTOForUpdate(user);
        return userDTOForUpdate;
    }




    public void deleteUser(long id){
        if(userService.getUser(id)==null) throw new NoSuchUser("There is no user with id "+id);
        userService.deleteUser(id);
    }
}

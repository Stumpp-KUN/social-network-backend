package com.network.backend.web.facade;

import com.network.backend.web.dto.user.UserDTOForCreate;
import com.network.backend.web.dto.user.UserDTOForRead;
import com.network.backend.web.dto.user.UserDTOForUpdate;
import com.network.backend.model.exception.NoSuchUser;
import com.network.backend.model.Users;
import com.network.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public UserDTOForCreate createUser(UserDTOForCreate user){
        Users users1 =userService.saveUser(getEntityByCreateUserDTO(user));
        return createUserDTO(users1);
    }

    private Users getEntityByCreateUserDTO(UserDTOForCreate user){
        Users temp=user.getEntity();
        return temp;
    }

    public UserDTOForCreate createUserDTO(Users users){
        UserDTOForCreate userDTOForCreate=new UserDTOForCreate(users);
        return userDTOForCreate;
    }




    public UserDTOForRead readUser(long id){
        Users users =userService.getUser(id);
        return readUserDTO(users);
    }

    public UserDTOForRead readUserDTO(Users users){
         UserDTOForRead userDTOForRead=new UserDTOForRead(users);
         return userDTOForRead;
    }

    public Users getUserDTORead(UserDTOForRead userDTOForRead){
        Users users=userDTOForRead.getEntity();
        return users;
    }

    public UserDTOForUpdate updateUserDTO(UserDTOForUpdate user){
        Users users1 =userService.updateUser(getEntityByUpdateUserDTO(user));
        return updateUserDTO(users1);
    }

    public Users getEntityByUpdateUserDTO(UserDTOForUpdate user){
        Users temp=user.getEntity();
        return temp;
    }

    public UserDTOForUpdate updateUserDTO(Users users){
        UserDTOForUpdate userDTOForUpdate=new UserDTOForUpdate(users);
        return userDTOForUpdate;
    }




    public void deleteUser(long id){
        if(userService.getUser(id)==null) throw new NoSuchUser("There is no user with id "+id);
        userService.deleteUser(id);
    }
}

package com.network.backend.controller;

import com.network.backend.dto.user.UserDTOForCreate;
import com.network.backend.dto.user.UserDTOForRead;
import com.network.backend.dto.user.UserDTOForUpdate;
import com.network.backend.exception.ExceptionApi;
import com.network.backend.exception.NoSuchUser;
import com.network.backend.facade.UserFasad;
import com.network.backend.model.User;
import com.network.backend.service.UserService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private UserFasad userFasad=new UserFasad();

    @PostMapping()
    public ResponseEntity<UserDTOForCreate> addNewUser(@RequestBody UserDTOForCreate user){
        return new ResponseEntity<>(userFasad.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTOForRead> getUser(@PathVariable long id){
        return new ResponseEntity<>(userFasad.readUser(id),HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserDTOForUpdate> updateUser(@RequestBody UserDTOForUpdate user){;
        return new ResponseEntity<>(userFasad.updateUserDTO(user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id)  {
        userFasad.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

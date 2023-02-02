package com.network.backend.controllers;

import com.network.backend.exception.ExceptionApi;
import com.network.backend.exception.NoSuchUser;
import com.network.backend.fasad.MessageFasad;
import com.network.backend.fasad.UserFasad;
import com.network.backend.fasad.dto.user.UserDTO;
import com.network.backend.fasad.dto.user.UserDTOForCreate;
import com.network.backend.fasad.dto.user.UserDTOForRead;
import com.network.backend.fasad.dto.user.UserDTOForUpdate;
import com.network.backend.models.User;
import com.network.backend.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
    //@Autowired
    //почему-то не автоконфигурируется, хотя @Service явл разновидностью @Component
    private UserService userService=new UserService();
    private UserFasad userFasad=new UserFasad();

    @PostMapping(path = "/users",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        userService.saveUser(userFasad.createUserDTO(user));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        if(userService.getUser(id)==null) throw new NoSuchUser("There is no user with id "+id);
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        System.out.println("rt");
        userService.updateUser(userFasad.updateUserDTO(user));
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) throws NotFoundException {
        ExceptionApi exceptionApi=new ExceptionApi();
        User user=userService.getUser(id);
        if(user==null) throw new NoSuchUser("There is no user with id "+id);

        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }







}

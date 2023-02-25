package com.network.backend.web.controller;

import com.network.backend.web.dto.user.UserDTOForCreate;
import com.network.backend.web.dto.user.UserDTOForRead;
import com.network.backend.web.dto.user.UserDTOForUpdate;
import com.network.backend.web.facade.UserFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFasad;

    @PostMapping("/")
    public ResponseEntity<UserDTOForCreate> addNewUser(@RequestBody @Valid UserDTOForCreate user){
        return new ResponseEntity<>(userFasad.createUser(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTOForRead> getUser(@PathVariable long id){
        return new ResponseEntity<>(userFasad.readUser(id),HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<UserDTOForUpdate> updateUser(@RequestBody @Valid UserDTOForUpdate user){
        return new ResponseEntity<>(userFasad.updateUserDTO(user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id)  {
        userFasad.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

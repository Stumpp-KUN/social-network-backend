package com.network.backend.service;

import com.network.backend.model.exception.NoSuchUser;
import com.network.backend.model.Users;
import com.network.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Users saveUser(Users users){;
        return userRepository.save(users);
    }

    public Users getUser(long id){
        return userRepository.findById(id).orElseThrow(()->new NoSuchUser("There is not user with id "+id));
    }

    @Transactional
    public Users updateUser(Users users){
        return userRepository.save(users);
    }

    @Transactional
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}

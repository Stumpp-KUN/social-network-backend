package com.network.backend.service;

import com.network.backend.model.Users;
import com.network.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Users saveUser(Users users){;
        return userRepository.save(users);
    }

    @Transactional
    public Users getUser(long id){
        Optional<Users> user=userRepository.findById(id);
        if(user.isEmpty()) return null;
        return user.get();
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

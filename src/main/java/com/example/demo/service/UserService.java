package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exceptions.UserException;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserById(UUID id){
        return userRepository.findById(id).orElseThrow(()-> new UserException("User not found by ID:" + id));
    }

    public UUID createUser(User user){
        return userRepository.save(user).getId();
    }

}

package com.ftr.authentication.service;

import com.ftr.authentication.model.Users;
import com.ftr.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean findUserByEmail(String email) {
       return userRepository.existsByEmail(email);
    }

    public void saveUser(Users users) {
        userRepository.save(users);
    }

    public Optional<Users> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}

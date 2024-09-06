package com.example.Final.Service;

import com.example.Final.Entities.User;
import com.example.Final.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Long addUser(User user) {
        return userRepository.save(user).getId();
    }
}
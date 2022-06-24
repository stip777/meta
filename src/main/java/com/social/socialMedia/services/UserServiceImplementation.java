package com.social.socialMedia.services;

import com.social.socialMedia.model.User;
import com.social.socialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepo;
//    @Autowired
//    JwtToken jwtToken;

    public void createUser(User newUser){
        userRepo.save(newUser);
    }
    public Iterable<User> getUsers(){
        return userRepo.findAll();
    }

    public Optional<User> findByUsername(String username){
        return Optional.ofNullable(userRepo.findByUsername(username));
    }
}

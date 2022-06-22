package com.social.socialMedia.controller;

import com.social.socialMedia.model.User;
import com.social.socialMedia.repository.UserRepository;
import com.social.socialMedia.resource.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return ResponseEntity.status(201).body(this.userRepository.save(user));
    }

//    @GetMapping("/login")
//    public ResponseEntity<User> login(@RequestBody UserRequest userRequest){
//        this.userRepository.findBy()
//    }
}

package com.social.socialMedia.controller;

import com.social.socialMedia.exception.UserException;
import com.social.socialMedia.model.User;
import com.social.socialMedia.repository.UserRepository;
import com.social.socialMedia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired(required = true)
    UserService userService;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody Map<String, String> userDetails) throws UserException {
        // Retrieve username entered
        String username = userDetails.get("username");

        if(!userService.findByUsername(username).isEmpty()){
            // username already exists
            throw new UserException("Username already exists");
        } else {
            String password = userDetails.get("password");
            String hashedPassword = new BCryptPasswordEncoder().encode(password);
            User newUser = new User(username, hashedPassword);
            userService.createUser(newUser);
            return new ResponseEntity<>("New user was registered", HttpStatus.CREATED);
        }
    }
}

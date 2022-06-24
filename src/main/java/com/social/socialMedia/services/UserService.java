package com.social.socialMedia.services;

import com.social.socialMedia.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserService {
    void createUser(User newUser);
    Iterable<User> getUsers();
    Optional<User> findByUsername(String username);
}

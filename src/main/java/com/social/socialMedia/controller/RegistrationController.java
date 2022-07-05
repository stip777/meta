package com.social.socialMedia.controller;

import com.social.socialMedia.model.ERole;
import com.social.socialMedia.model.Role;
import com.social.socialMedia.model.User;
import com.social.socialMedia.model.jwtRequest.SignupRequest;
import com.social.socialMedia.model.jwtResponse.MessageResponse;
import com.social.socialMedia.repository.RoleRepository;
import com.social.socialMedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;

    @ModelAttribute("user")
    public SignupRequest signupRequest() {
        return new SignupRequest();
    }

    @GetMapping
    public String showRegistrationForm() {return "registration";}

    @PostMapping
    public String registerUser(@ModelAttribute("user") SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
        ResponseEntity
            .badRequest()
            .body(new MessageResponse("Error: Username is already taken!"));
        return "redirect:/registration";
    }
    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
            encoder.encode(signUpRequest.getPassword()));
    Set<String> strRoles = signUpRequest.getRoles();
    Set<Role> roles = new HashSet<>();
    if (strRoles == null) {
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
    } else {
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                    break;
                default:
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        });
    }

    user.setRoles(roles);
    userRepository.save(user);
    return "redirect:/registerSuccess";
    }

}

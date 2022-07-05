package com.social.socialMedia.controller;

import javax.validation.Valid;

import com.social.socialMedia.RegistrationForm;
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

import java.util.HashSet;
import java.util.Set;


@Controller
public class AppController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;

//	@GetMapping("/")
//	public String landingPage() {
//		return "index";
//	}
	
//	@RequestMapping("/registration")
//	public String registrationPage(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			return "registration";
//		}
//		return "redirect:/";
//	}
	
//	@GetMapping("/registration")
//	public String register(RegistrationForm registrationForm) {
//		return "registration";
//	}
//	
//	@PostMapping("/registration")
//	public String registrationPage(@Valid RegistrationForm registrationForm, Errors errors, Model model) {
//		if (errors.hasErrors()) {
//			return "registration";
//		} else {
//			model.addAttribute("message", "Registered successfully.");
//			return "registration";
//		}
//	}
	
//	@GetMapping("/registration")
//	public String register() { return "registration";}

	@GetMapping("/registerSuccess")
	public String registerSuccess() {return "registerSuccess";}
	
//	@RequestMapping("registration", RequestMethod.POST)
//	public String doRegistration(@ModelAttribute("user") RegistrationForm registrationForm)
	
	@RequestMapping("/main")
	public String mainPage() {
		return "main";
	}
}

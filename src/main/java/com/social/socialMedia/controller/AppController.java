package com.social.socialMedia.controller;

import javax.validation.Valid;

import com.social.socialMedia.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String landingPage() {
		return "index";
	}
	
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
	
	@GetMapping("/registerForm")
	public String register(Model model) {
		RegistrationForm registrationForm = new RegistrationForm();
		model.addAttribute("user", registrationForm);
		
		return "registration";
	}
	
	@PostMapping("/register")
	public String registerSuccess(@ModelAttribute ("user") RegistrationForm registrationForm) {
		System.out.println(registrationForm);
		return "registerSuccess";
	}
	
//	@RequestMapping("registration", RequestMethod.POST)
//	public String doRegistration(@ModelAttribute("user") RegistrationForm registrationForm)
	
	@RequestMapping("/main")
	public String mainPage() {
		return "main";
	}
}

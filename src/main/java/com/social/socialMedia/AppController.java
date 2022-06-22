package com.social.socialMedia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@GetMapping("")
	public String landingPage() {
		return "index";
	}
	
	@RequestMapping("/registration.html")
	public String registrationPage() {
	    return "registration";
	}
	
	@RequestMapping("/index.html")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping("/main.html")
	public String mainPage() {
		return "main";
	}
}

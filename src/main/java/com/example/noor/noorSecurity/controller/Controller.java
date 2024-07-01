package com.example.noor.noorSecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping
	public String Home(Authentication authentication) { //to get the authority user such as either it is role or user
		return "hellow"   + authentication.getName() + authentication.getAuthorities().toString();
	}
}

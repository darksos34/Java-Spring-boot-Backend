package com.FullStack.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) // Cross origin allowed for port 3000
@RestController // Instruct Spring Boot that this is the REST Controller
@RequestMapping("/api/test") // Link to access GET/POST/PUT/DELETE requests
public class TestController {

	@GetMapping("/all") // No authentication required for access
	public String allAccess() {
		return "Public Content.";
	}

	@GetMapping("/user") // Allow access to /user when role = USER, MODERATOR and/or ADMIN
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod") // Allow access to /mod when role = MODERATOR
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin") // Allow access to /admin when role = ADMIN
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}

}

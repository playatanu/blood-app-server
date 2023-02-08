package com.nvc.bloodapp.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nvc.bloodapp.api.models.User;
import com.nvc.bloodapp.api.responses.AuthResponse;
import com.nvc.bloodapp.api.services.AuthService;


@RestController()
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> signup(@RequestBody User user) {
		return new ResponseEntity<>(this.authService.signup(user),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody User user) {
		return new ResponseEntity<>(this.authService.login(user),HttpStatus.OK);
	}
}

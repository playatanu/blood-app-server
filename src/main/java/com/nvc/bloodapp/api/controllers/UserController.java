package com.nvc.bloodapp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nvc.bloodapp.api.models.User;
import com.nvc.bloodapp.api.responses.ApiResponse;
import com.nvc.bloodapp.api.responses.UserResponse;
import com.nvc.bloodapp.api.services.UserService;

@RestController()
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Get User By Id
	@GetMapping("/")
	public ResponseEntity<UserResponse> getUserById(@RequestParam(name="id") Long userId) {
		return new ResponseEntity<>(this.userService.getUserById(userId),HttpStatus.OK);	
	}
	//Get All Active User
	@GetMapping("/active")
	public ResponseEntity<List<UserResponse>> getActiveUsers() {
		return new ResponseEntity<>(this.userService.getActiveUsers(),HttpStatus.OK);	
	}
	//Put User By Id
	@PutMapping("/")
	public ResponseEntity<ApiResponse> editProfile(@RequestParam(name="id")  Long userId,@RequestBody User user) {
		this.userService.updateUserById(userId,user);
		return new ResponseEntity<>(new ApiResponse("profile update successfully",true),HttpStatus.OK);
	}
	//Put User Status By Id
	@PutMapping("/status/")
	public ResponseEntity<ApiResponse> setStatusActiveByUserId(@RequestParam(name="id")  Long userId) {
		this.userService.updateStatusById(userId);
		return new ResponseEntity<>(new ApiResponse("profile status update successfully",true),HttpStatus.OK);	
	}

}

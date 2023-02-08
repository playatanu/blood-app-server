package com.nvc.bloodapp.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nvc.bloodapp.api.exceptions.CustomException;
import com.nvc.bloodapp.api.exceptions.NotFoundException;
import com.nvc.bloodapp.api.models.User;
import com.nvc.bloodapp.api.repositories.UserRepositorie;
import com.nvc.bloodapp.api.responses.AuthResponse;

@Component
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepositorie userRepositorie;


	@Override
	public AuthResponse signup(User user) {
		User userGet = this.userRepositorie.findByEmail(user.getEmail());
		if (userGet != null)throw new CustomException("email already exists");
		else {
			User newUser = this.userRepositorie.save(user);
			return new AuthResponse(newUser.getId(),true);
			}
	}

	@Override
	public AuthResponse login(User user) {
		User userGet = this.userRepositorie.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (userGet == null)throw new NotFoundException("email and password invalid");
		else return new AuthResponse(userGet.getId(),true);
	}

}

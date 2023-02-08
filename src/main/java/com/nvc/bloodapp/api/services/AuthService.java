package com.nvc.bloodapp.api.services;

import com.nvc.bloodapp.api.models.User;
import com.nvc.bloodapp.api.responses.AuthResponse;

public interface AuthService {
	
	public AuthResponse signup(User user);
	public AuthResponse login(User user);
}

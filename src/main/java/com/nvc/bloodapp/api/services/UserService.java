package com.nvc.bloodapp.api.services;

import java.util.List;

import com.nvc.bloodapp.api.models.User;
import com.nvc.bloodapp.api.responses.UserResponse;

public interface UserService {
	
	public UserResponse getUserById(Long userId);
	public List<UserResponse> getActiveUsers();
	public void updateUserById(Long userId,User user);
	public void updateStatusById(Long userId);
}

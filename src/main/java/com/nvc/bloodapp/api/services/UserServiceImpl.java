package com.nvc.bloodapp.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import com.nvc.bloodapp.api.exceptions.EmptyFieldException;
import com.nvc.bloodapp.api.exceptions.NotFoundException;
import com.nvc.bloodapp.api.models.User;
import com.nvc.bloodapp.api.repositories.UserRepositorie;
import com.nvc.bloodapp.api.responses.UserResponse;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositorie userRepositorie;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void updateUserById(Long userId,User user) {

		if(userId == null || user.getName() == null || user.getPhone()==null) {
			throw new EmptyFieldException("field not found");
		}
		
		if(userId != null && user.getName() != null && user.getPhone()!=null) {
			Integer row = this.userRepositorie.updateNameAndPhone(userId,user.getName(),user.getPhone());
			if(row!=1) throw new NotFoundException("user not found");
		}

	}

	@Override
	public void updateStatusById(Long userId) {
		Integer row = this.userRepositorie.updateStatus(userId);
		if(row!=1) {
			 throw new NotFoundException("user not found");
		}
	}

	@Override
	public UserResponse getUserById(Long userId) {
		User userGet =  this.userRepositorie.findById(userId).orElseThrow();
		return modelMapper.map(userGet,UserResponse.class);
	
	}

	@Override
	public List<UserResponse> getActiveUsers() {
	 List<User> users = this.userRepositorie.getActiveUsers();
		return users.stream().map((user) -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
	}


}

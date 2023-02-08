package com.nvc.bloodapp.api.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nvc.bloodapp.api.models.BloodRequest;

import lombok.Data;

@Data
public class UserResponse {
	private Long id;
	private String name;
	private String email;
	@JsonIgnore
	private String password;
	private String phone;
	private String bloodType;
	private String gender;
	private boolean status;
	@JsonIgnore
	private List<BloodRequest> bloodRequests = new ArrayList<>();

}

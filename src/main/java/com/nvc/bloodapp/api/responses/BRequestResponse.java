package com.nvc.bloodapp.api.responses;


import com.nvc.bloodapp.api.models.BloodRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BRequestResponse {
	private BloodRequest bloodRequest;
	private UserResponse userResponse;
}

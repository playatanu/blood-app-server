package com.nvc.bloodapp.api.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nvc.bloodapp.api.exceptions.NotFoundException;
import com.nvc.bloodapp.api.models.BloodRequest;
import com.nvc.bloodapp.api.models.User;
import com.nvc.bloodapp.api.repositories.BloodRequestRepositorie;
import com.nvc.bloodapp.api.repositories.UserRepositorie;
import com.nvc.bloodapp.api.responses.BRequestResponse;
import com.nvc.bloodapp.api.responses.UserResponse;

@Component
public class BloodRequestServiceImpl implements BloodRequestService{
	
	@Autowired
	private BloodRequestRepositorie brRepositorie;
	
	@Autowired
	private UserRepositorie userRepositorie;
	
	@Autowired
	private ModelMapper modelMaper;
	
	@Override
	public List<BRequestResponse> getActiveBloodRequests() {
		List<BloodRequest> bRequests =  this.brRepositorie.getActiveBloodRequests();
		 
		 List<BRequestResponse> bRequestResponses = bRequests.stream().map((bRequest)-> 
		 new BRequestResponse(bRequest,modelMaper.map(bRequest.getUser(), UserResponse.class)))
				 .collect(Collectors.toList());
		 
		 return bRequestResponses;
	}

	@Override
	public BloodRequest newBloodRequest(Long userId,String bloodType) {
		
		User user = this.userRepositorie.findById(userId).orElseThrow(()-> new NotFoundException("user not found"));
		BloodRequest newRequest = new BloodRequest();
		newRequest.setUser(user);
		newRequest.setBloodType(bloodType);
		newRequest.setDate(new Date());
		newRequest.setStatus(true);
		BloodRequest savedRequest = this.brRepositorie.save(newRequest);
		return savedRequest;
	}

	@Override
	public void deActiveBloodRequestById(Long brId) {
		Integer row = this.brRepositorie.deActiveBloodRequestById(brId);
		System.out.println(row);
		if(row!=1) throw new NotFoundException("blood request not found");
	}

	@Override
	public BRequestResponse getBRequestedById(Long brId) {
		BloodRequest br = this.brRepositorie.findById(brId).orElseThrow(()-> new NotFoundException("blood request not found"));
		User user = br.getUser();
		return new BRequestResponse(br,modelMaper.map(user,UserResponse.class));
	}

	@Override
	public List<BloodRequest> getBRequestedUserByUserId(Long userId) {
		return this.brRepositorie.getBloodRequestsByUserID(userId);
	}

}

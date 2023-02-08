package com.nvc.bloodapp.api.services;

import java.util.List;

import com.nvc.bloodapp.api.models.BloodRequest;
import com.nvc.bloodapp.api.responses.BRequestResponse;

public interface BloodRequestService {
	public List<BRequestResponse> getActiveBloodRequests();
	public List<BloodRequest> getBRequestedUserByUserId(Long userId);
	public BRequestResponse getBRequestedById(Long brId);
	public BloodRequest newBloodRequest(Long userId,String bloodType);
	public void deActiveBloodRequestById(Long brId);
}

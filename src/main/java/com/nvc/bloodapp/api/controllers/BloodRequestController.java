package com.nvc.bloodapp.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nvc.bloodapp.api.models.BloodRequest;
import com.nvc.bloodapp.api.responses.ApiResponse;
import com.nvc.bloodapp.api.responses.BRequestResponse;
import com.nvc.bloodapp.api.services.BloodRequestService;

@RestController()
@RequestMapping("/brequest")
public class BloodRequestController {
	
	@Autowired
	private BloodRequestService bloodRequestService;
	
	@PostMapping("/{type}/")
	public ResponseEntity<BloodRequest> newBloodRequest(@RequestParam(name="user")Long userId,@PathVariable(name = "type") String bloodType){
		return new ResponseEntity<>(this.bloodRequestService.newBloodRequest(userId,bloodType),HttpStatus.OK);
	}

	@GetMapping("/active")
	public ResponseEntity<List<BRequestResponse>> getActiveBloodRequests(){
		return new ResponseEntity<>(this.bloodRequestService.getActiveBloodRequests(),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<BRequestResponse> getBRequestedUserByBRId(@RequestParam(name="id") Long brId){
		return new ResponseEntity<>(this.bloodRequestService.getBRequestedById(brId),HttpStatus.OK);
	}
	
	@GetMapping("/user/")
	public ResponseEntity<List<BloodRequest>> getBRequestedUserByUserId(@RequestParam(name="id") Long userId){
		return new ResponseEntity<>(this.bloodRequestService.getBRequestedUserByUserId(userId),HttpStatus.OK);
	}
	
	@PutMapping("/close/")
	public ResponseEntity<ApiResponse> deActiveBloodRequestById(@RequestParam(name="id") Long brId){
		this.bloodRequestService.deActiveBloodRequestById(brId);
		return new ResponseEntity<>(new ApiResponse("blood request closed",true ),HttpStatus.OK);
	}

}

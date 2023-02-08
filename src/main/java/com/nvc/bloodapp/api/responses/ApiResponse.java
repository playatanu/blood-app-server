package com.nvc.bloodapp.api.responses;

import lombok.*;

@Data
@AllArgsConstructor
public class ApiResponse {
	
	private String message;
	private Boolean success;

}

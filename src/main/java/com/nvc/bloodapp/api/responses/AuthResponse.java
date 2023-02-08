package com.nvc.bloodapp.api.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
	private Long id;
	private Boolean success;
}

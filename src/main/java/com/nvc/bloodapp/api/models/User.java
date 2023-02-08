package com.nvc.bloodapp.api.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long id;
	@Column(name = "user_name", nullable = false)
	private String name;
	@Column(name = "user_email", nullable = false)
	private String email;
	@Column(name = "user_password", nullable = false)
	private String password;
	@Column(name = "user_phone", nullable = false, length = 10)
	private String phone;
	@Column(name = "user_blood_type", nullable = false)
	private String bloodType;
	@Column(name = "user_gender", nullable = false)
	private String gender;
	@Column(name = "user_status", nullable = false)
	private boolean status;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<BloodRequest> bloodRequests = new ArrayList<>();

	

}

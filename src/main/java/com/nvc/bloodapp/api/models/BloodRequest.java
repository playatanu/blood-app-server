package com.nvc.bloodapp.api.models;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="bloodrequest")
public class BloodRequest {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="br_id",nullable = false,unique = true)
	private Long id;
	@Column(name="br_blood_type",nullable = false)
	private String bloodType;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="user_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	@Column(name="br_date",nullable = false)
	private Date date;
	
	@Column(name="br_status",nullable = false)
	private Boolean status;
	

}

package com.jsp.apnahealthcheckupspringbootrestapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

	@Id
	private int doctorId;
	private String doctorName;
	private String doctorSpecialist;
	
	@ManyToOne
//	@JsonManagedReference
	@JsonIgnore
	private Hospital hospital;
	
	@ManyToMany(mappedBy = "doctors")
	@JsonIgnore
	private List<Patient> patients;
}

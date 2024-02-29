package com.jsp.apnahealthcheckupspringbootrestapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

	@Id
	private int hospitalId;
	private String hospitalName;
	private int noOfBeds;
	private int noOfAmbulance;
	
	@OneToMany(mappedBy = "hospital")
	@JsonIgnore
	private List<Doctor> doctors;
	
	@OneToMany(mappedBy = "hospital")
	@JsonIgnore
	private List<Nurse> nurses;
	
	@OneToMany(mappedBy = "hospital")
	@JsonIgnore
	private List<Patient> patients;
}

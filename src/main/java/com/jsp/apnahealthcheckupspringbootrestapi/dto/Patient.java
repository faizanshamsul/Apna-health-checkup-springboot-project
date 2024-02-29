package com.jsp.apnahealthcheckupspringbootrestapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

	@Id
	private int patientId;
	private String patientName;
	private String diseaseType;
	private int patientAge;
	
	@ManyToOne
	@JsonIgnore
	private Hospital hospital;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Doctor> doctors;
	
	@ManyToOne
	@JsonIgnore
	private Nurse nurse;
}

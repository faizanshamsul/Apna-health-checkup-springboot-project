package com.jsp.apnahealthcheckupspringbootrestapi.dto;

import java.util.List;

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
public class Nurse {

	@Id
	private int nurseId;
	private String nurseName;
	
	@ManyToOne
	private Hospital hospital;
	
	@OneToMany(mappedBy = "nurse")
	private List<Patient> patients;
}

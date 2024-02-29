package com.jsp.apnahealthcheckupspringbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	public Patient findBypatientId(int patientId);
}

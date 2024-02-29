package com.jsp.apnahealthcheckupspringbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	public Doctor findBydoctorId(int doctorId);
}

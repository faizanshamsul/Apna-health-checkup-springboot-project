package com.jsp.apnahealthcheckupspringbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

	public Hospital findByhospitalId(int hospitalId);
}

package com.jsp.apnahealthcheckupspringbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Nurse;

public interface NurseRepository extends JpaRepository<Nurse, Integer>{

	public Nurse findBynurseId(int nurseId);
}

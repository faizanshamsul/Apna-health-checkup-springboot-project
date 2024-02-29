package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.HospitalRepository;
@Repository
public class HospitalDao {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	//save_method
	public Hospital saveHospitalDao(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
}

package com.jsp.apnahealthcheckupspringbootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService service;
	
	@PostMapping(value = "/saveHospital")
	public ResponseStructure<Hospital> saveHospitalController(@RequestBody Hospital hospital){
		return service.saveHospitalService(hospital);
	}
}

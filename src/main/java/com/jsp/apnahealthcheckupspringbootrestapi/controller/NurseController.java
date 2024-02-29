package com.jsp.apnahealthcheckupspringbootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Nurse;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.service.NurseService;

@RestController
public class NurseController {

	@Autowired
	private NurseService nurseService;
	
	// save_method
	@PostMapping(value = "/saveNurse/{hospitalId}")
	public ResponseStructure<Nurse> saveNurseController(@PathVariable int hospitalId, @RequestBody Nurse nurse) {
		return nurseService.saveNurseService(hospitalId, nurse);
	}
}

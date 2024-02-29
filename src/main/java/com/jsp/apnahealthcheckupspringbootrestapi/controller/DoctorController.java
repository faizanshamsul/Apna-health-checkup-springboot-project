package com.jsp.apnahealthcheckupspringbootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	// save_method
	@PostMapping(value = "/saveDoctor/{hospitalId}")
	public ResponseStructure<Doctor> saveDoctorController(@PathVariable int hospitalId, @RequestBody Doctor doctor) {
		return doctorService.saveDoctorService(hospitalId, doctor);
	}

	// save_doctor_method_with_hospitalId_PatientId
	@PostMapping(value = "/saveDoctor2/{hospitalId}/{patientId}")
	public ResponseStructure<Doctor> saveDoctorController(@PathVariable int hospitalId,@PathVariable int patientId,@RequestBody Doctor doctor) {
		return doctorService.saveDoctorService2(hospitalId, patientId, doctor);
	}
}

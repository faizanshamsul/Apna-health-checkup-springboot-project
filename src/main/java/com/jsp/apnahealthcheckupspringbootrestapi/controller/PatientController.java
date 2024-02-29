package com.jsp.apnahealthcheckupspringbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	// save_method
	@PostMapping(value = "/savePatient/{hospitalId}/{doctorId}/{nurseId}")
	public ResponseStructure<Patient> savePatientService(@PathVariable int hospitalId, @PathVariable int doctorId,
			@PathVariable int nurseId, @RequestBody Patient patient) {
		return patientService.savePatientService(hospitalId, doctorId, nurseId, patient);
	}

	// save_multiple_patient_with_one_doctor
	@PostMapping(value = "/saveMultiplePatientsWithDoctor/{doctorId}")
	public ResponseStructure<List<Patient>> saveMultiplePatientsWithDoctor(@PathVariable int doctorId, @RequestBody List<Patient> patients) {
		return patientService.saveMultiplePatientsWithDoctor(doctorId, patients);
	}
}

package com.jsp.apnahealthcheckupspringbootrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.PatientDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;

	@Autowired
	private ResponseStructure<Patient> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Patient>> responseStructure2;

	// save_method
	public ResponseStructure<Patient> savePatientService(int hospitalId, int doctorId, int nurseId, Patient patient) {
		Patient patient2 = patientDao.savePatientDao(hospitalId, doctorId, nurseId, patient);
		if(patient2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("patient data has been saved");
			responseStructure.setStatusData(patient2);
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("check hospital id and nurse id");
			responseStructure.setStatusData(patient2);
		}
		return responseStructure;
	}

	// save_multiple_patient_with_one_doctor
	public ResponseStructure<List<Patient>> saveMultiplePatientsWithDoctor(int doctorId, List<Patient> patients){
		List<Patient> patient2 = patientDao.saveMultiplePatientsWithDoctor(doctorId, patients);
		if(patient2 != null) {
			responseStructure2.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure2.setStatusMessage("Multiple-Data-Stored");
			responseStructure2.setStatusData(patient2);
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure2.setStatusMessage("Multiple-Data-not-Stored");
			responseStructure2.setStatusData(patient2);
		}
		return responseStructure2;
	}
}

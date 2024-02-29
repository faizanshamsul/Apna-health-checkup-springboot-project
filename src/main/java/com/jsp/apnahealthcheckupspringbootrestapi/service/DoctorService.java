package com.jsp.apnahealthcheckupspringbootrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.DoctorDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Autowired
	private ResponseStructure<Doctor> responseStructure;

	// save_method
	public ResponseStructure<Doctor> saveDoctorService(int hospitalId, Doctor doctor) {
		Doctor doctor2 = doctorDao.saveDoctorDao(hospitalId, doctor);

		if (doctor2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Doctor registered successfully...");
			responseStructure.setStatusData(doctor2);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Check hospital id successfully..");
			responseStructure.setStatusData(doctor2);
		}
		return responseStructure;
	}

	// save_doctor_method_with_hospitalId_PatientId
	public ResponseStructure<Doctor> saveDoctorService2(int hospitalId, int patientId, Doctor doctor) {
		Doctor doctor2 = doctorDao.saveDoctor2Dao(hospitalId, patientId, doctor);
		if (doctor2 != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setStatusMessage("Doctor registered successfully...");
			responseStructure.setStatusData(doctor2);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("Check hospital id successfully..");
			responseStructure.setStatusData(doctor2);
		}
		return responseStructure;
	}
}

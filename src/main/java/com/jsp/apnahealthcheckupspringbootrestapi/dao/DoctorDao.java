package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.DoctorRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.HospitalRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.PatientRepository;

@Repository
public class DoctorDao {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	//save_method
	public Doctor saveDoctorDao(int hospitalId, Doctor doctor) {
		Hospital hospital = hospitalRepository.findByhospitalId(hospitalId);
		
		if(hospital != null) {
			doctor.setHospital(hospital);
			return doctorRepository.save(doctor);
		}else {
			return null;
		}
	}

	//save_doctor_method_with_hospitalId_PatientId
	public Doctor saveDoctor2Dao(int hospitalId, int patientId, Doctor doctor) {
		Hospital hospital = hospitalRepository.findByhospitalId(hospitalId);
		Patient patient = patientRepository.findBypatientId(patientId);
		
		List<Patient> patients = new ArrayList<Patient>(Arrays.asList(patient));
		
		if(hospital != null && patient != null) {
			doctor.setHospital(hospital);
			doctor.setPatients(patients);
			return doctorRepository.save(doctor);
		}else {
			return null;
		}
	}
}

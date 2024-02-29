package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Doctor;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Hospital;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Nurse;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Patient;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.DoctorRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.HospitalRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.NurseRepository;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.PatientRepository;

@Repository
public class PatientDao {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private NurseRepository nurseRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private HospitalRepository hospitalRepository;

	//save_method
	public Patient savePatientDao(int hospitalId, int doctorId, int nurseId, Patient patient) {
		Hospital hospital = hospitalRepository.findByhospitalId(hospitalId);
		Doctor doctor = doctorRepository.findBydoctorId(doctorId);
		List<Doctor> doctors = new ArrayList<Doctor>(Arrays.asList(doctor));
		Nurse nurse = nurseRepository.findBynurseId(nurseId);
		if (hospital != null && doctor != null && nurse != null) {
			patient.setHospital(hospital);
			patient.setDoctors(doctors);
			patient.setNurse(nurse);
			return patientRepository.save(patient);
		}else {
			return null;			
		}
	}
	
	//save_multiple_patient_with_one_doctor
	public List<Patient> saveMultiplePatientsWithDoctor(int doctorId, List<Patient> patients){
		Doctor doctor = doctorRepository.findBydoctorId(doctorId);
		List<Doctor> doctors = new ArrayList<Doctor>(Arrays.asList(doctor));
		if(doctor != null) {
			for(Patient patient : patients ) {
				patient.setDoctors(doctors);
			}
			return patientRepository.saveAll(patients);
		}else {
			return null;
		}
		
	}
}

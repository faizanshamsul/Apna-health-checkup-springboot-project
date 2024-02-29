package com.jsp.apnahealthcheckupspringbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Admin;
import com.jsp.apnahealthcheckupspringbootrestapi.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository adminRepository;
	
	//save-method
	public Admin saveAdminDao(Admin admin) {
		return adminRepository.save(admin);
	}
	
	//login-admin-method
	public Admin loginAdminDao(String adminEmail) {
		return adminRepository.findByadminEmail(adminEmail);
	}
	//get_all_admin
	public List<Admin> getAllAdminDataDao(){
		return adminRepository.findAll();
	}
}

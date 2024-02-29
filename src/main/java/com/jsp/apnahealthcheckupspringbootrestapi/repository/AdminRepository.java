package com.jsp.apnahealthcheckupspringbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
                       //attribute name same as in dto class
	public Admin findByadminEmail(String adminEmail);
}

package com.jsp.apnahealthcheckupspringbootrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.apnahealthcheckupspringbootrestapi.dto.Admin;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.service.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
//@RequestMapping(value = "/getAdmin")
public class AdminController {

	@Autowired
	public AdminService adminService;

	// save-method
	@PostMapping(value = "/saveAdmin")
	public ResponseStructure<Admin> saveAdminController(@RequestBody Admin admin) {
		return adminService.saveAdminService(admin);
	}

	// login-admin-method
	@GetMapping(value = "/loginAdmin/{adminEmail}/{adminPassword}")
	public ResponseStructure<Admin> loginAdminController(@PathVariable String adminEmail,
			@PathVariable String adminPassword) {
		return adminService.loginAdminService(adminEmail, adminPassword);
	}

	// logout-admin-method
	@GetMapping(value = "/logoutAdmin")
	public ResponseStructure<String> adminLogoutService() {
		return adminService.adminLogoutService();
	}

	// get_all_admin
	@GetMapping(value = "/getAllAdminData")
	public ResponseStructure<List<Admin>> getAllAdminDataController() {
		return adminService.getAllAdminDataService();
				
	}
}

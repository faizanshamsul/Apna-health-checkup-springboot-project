package com.jsp.apnahealthcheckupspringbootrestapi.service;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.apnahealthcheckupspringbootrestapi.dao.AdminDao;
import com.jsp.apnahealthcheckupspringbootrestapi.dto.Admin;
import com.jsp.apnahealthcheckupspringbootrestapi.response.ResponseStructure;
import com.jsp.apnahealthcheckupspringbootrestapi.verification.EmailPasswordVerification;

import ch.qos.logback.core.boolex.Matcher;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Service
public class AdminService {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private ResponseStructure<Admin> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Admin>> responseStructure2;

	@Autowired
	private ResponseStructure<String> logout;

	@Autowired
	private AdminDao adminDao;

	// save-method
	public ResponseStructure<Admin> saveAdminService(Admin admin) {

		String email = EmailPasswordVerification.verifyEmail(admin.getAdminEmail());
		String password = EmailPasswordVerification.verifyPassword(admin.getAdminPassword());

		if (email != null) {
			if (password != null) {
				adminDao.saveAdminDao(admin);
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setStatusMessage("successfull");// 200
				responseStructure.setStatusData(admin);
			} else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setStatusMessage("un_successfull, password is incorrect");
				responseStructure.setStatusData(admin);
			}
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setStatusMessage("email is incorrect");
			responseStructure.setStatusData(admin);
		}

		return responseStructure;
	}

	// login-admin-method
	public ResponseStructure<Admin> loginAdminService(String adminEmail, String adminPassword) {
		Admin admin = adminDao.loginAdminDao(adminEmail);

		if (admin != null) {
			if (admin.getAdminPassword().equals(adminPassword)) {
				httpSession.setAttribute("adminEmail", adminEmail);
				responseStructure.setStatusCode(HttpStatus.FOUND.value());
				responseStructure.setStatusMessage("login successfull");
				responseStructure.setStatusData(admin);
			} else {
				responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseStructure.setStatusMessage("Enter correct password");
				responseStructure.setStatusData(admin);
			}
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setStatusMessage("Enter correct email");
			responseStructure.setStatusData(admin);
		}
		return responseStructure;
	}

	// logout-admin-method
	public ResponseStructure<String> adminLogoutService() {
		if (httpSession.getAttribute("adminEmail") != null) {
			httpSession.invalidate();
			logout.setStatusCode(HttpStatus.OK.value());
			logout.setStatusMessage("admin logout successfully");
			logout.setStatusData("Session-has-been-expired");
		}
		return logout;
	}

	// get_all_admin
	public ResponseStructure<List<Admin>> getAllAdminDataService() {
		List<Admin> admins = adminDao.getAllAdminDataDao();
		if(admins != null) {
			responseStructure2.setStatusCode(HttpStatus.FOUND.value());
			responseStructure2.setStatusMessage("data-found");
			responseStructure2.setStatusData(admins);
		}else{
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setStatusMessage("data-not-found");
			responseStructure2.setStatusData(admins);
		}
		return responseStructure2;
		
	}

}

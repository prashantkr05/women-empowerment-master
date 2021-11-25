package com.capgemini.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Admin;
import com.capgemini.service.AdminService;

@RestController
public class AdminController {
	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;

	@PostMapping("/adminregister")
	public ResponseEntity<Admin> adminRegister(@RequestBody Admin admin) {
		LOG.info("adminregister");
		Admin adm = adminService.adminRegister(admin);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Admin Registered Successfully");
		LOG.info(headers.toString());
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(adm, headers, HttpStatus.OK);
		return response;

	}
	// http://localhost:8082/adminlogin
	@GetMapping("/adminlogin/{adminUserName}/{adminPassword}")
	public ResponseEntity<Admin> adminlogin(@PathVariable(name = "adminUserName") String adminUserName,
			@PathVariable(name = "AdminPassword") String adminPassword) {
		LOG.info("Controller login");
		Admin adm = adminService.adminLogin(adminUserName, adminPassword);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Welcome to login Admin");
		LOG.info(headers.toString());
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(adm, headers, HttpStatus.OK);
		return response;
	}
}

//---------------------------------------------------------------------------------------------------------------------------
//	@GetMapping("/adminlogin/{adminUsername}/{adminPassword}")
//public ResponseEntity<Admin> adminLogin(@RequestBody Admin adminUserName, @RequestBody Admin adminPassword) {
//	LOG.info("Controller adminLogin");
//	Admin adm = adminService.adminLogin(adminUserName);
//	adm = adminService.adminLogin(adminPassword);
//	HttpHeaders headers = new HttpHeaders();
//	headers.add("message", "Welcome Admin");
//	ResponseEntity<Admin> response = new ResponseEntity<Admin>(adm, headers, HttpStatus.OK);
//	return response;
//} // -------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------------------------------------------
//	@GetMapping("/adminLogin/{adminUserName}/{adminPassword}")
//	public ResponseEntity<Admin> adminLogin(@RequestBody Admin admin) {
//		LOG.info("adminLogin");
//		Admin adm = adminService.adminLogin(admin);
////		adm = adminService.adminLogin(adminPassword);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "Admin Login Successfully");
//		ResponseEntity<Admin> response = new ResponseEntity<Admin>(adm, headers, HttpStatus.OK);
//		return response;
//
//	}


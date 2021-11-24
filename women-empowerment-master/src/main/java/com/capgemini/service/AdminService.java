package com.capgemini.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.AdminAlreadyExistsException;
import com.capgemini.exception.AdminNotExistsException;
import com.capgemini.model.Admin;
import com.capgemini.repository.AdminRepository;

@Service
public class AdminService {
	private Admin tempUser;
	private Admin tempUser1;
	public boolean isLoggedIn;

	private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);
	@Autowired
	AdminRepository adminRepository;

	public Admin adminRegister(Admin admin) {
		LOG.info("adminregister");
		if (adminRepository.findByAdminUsername(admin.getAdminUsername()) != null
				&& adminRepository.findByAdminPassword(admin.getAdminPassword()) != null) {
			throw new AdminAlreadyExistsException("Admin Already registered");
		} else {
			return adminRepository.save(admin);
		}
	}

	public Admin adminLogin(Admin admin) {
		LOG.info(" Service adminlogin");
		tempUser = adminRepository.findByAdminUsername(admin.getAdminUsername());
		tempUser1 = adminRepository.findByAdminPassword(admin.getAdminPassword());
		if (tempUser.getAdminUsername().equalsIgnoreCase(admin.getAdminUsername())) {
			isLoggedIn = true;
			return tempUser;
		} else if (tempUser.getAdminPassword().equalsIgnoreCase(admin.getAdminPassword())) {
			isLoggedIn = true;
			return tempUser1;
		}
		throw new AdminNotExistsException();
	}

//	public Admin adminLogin(Admin admin) {)
//		LOG.info("adminlogin");
//		if (adminRepository.findByAdminUsername(admin.getAdminUsername()) != null
//				&& adminRepository.findByAdminPassword(admin.getAdminPassword()) != null)
//			return adminRepository.save(admin);
//		throw new AdminNotExistsException();
//	}

}

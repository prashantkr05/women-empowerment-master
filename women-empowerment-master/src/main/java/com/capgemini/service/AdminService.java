package com.capgemini.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exception.AdminAlreadyExistsException;
import com.capgemini.exception.InvalidLoginCredentialsException;
import com.capgemini.model.Admin;
import com.capgemini.repository.AdminRepository;

@Service
public class AdminService implements IAdminService {

	private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);
	@Autowired
	AdminRepository adminRepository;

	private Admin tempadmin;
	private Admin temppassword;
	public boolean isLoggedIn;

	@Override
	public Admin adminRegister(Admin admin) {
		LOG.info("adminregister");
		if (adminRepository.findByAdminUsername(admin.getAdminUsername()) != null
				&& adminRepository.findByAdminPassword(admin.getAdminPassword()) != null) {
			throw new AdminAlreadyExistsException("Admin Already registered");
		} else {
			return adminRepository.save(admin);
		}
	}

	@Override
	public Admin adminLogin(String adminUserName, String adminPassword) {
		LOG.info(" Service login");
		this.tempadmin = adminRepository.findByAdminUsername(adminUserName);
		this.temppassword = adminRepository.findByAdminUsername(tempadmin.getAdminPassword());
		if (tempadmin.getAdminUsername().equalsIgnoreCase(adminUserName)
				&& temppassword.getAdminPassword().equals(adminPassword)) {
			isLoggedIn = true;
			return tempadmin;
		} else {
			throw new InvalidLoginCredentialsException();
		}
	}
}

//-----------------------------------------------------Facing Problem---------------------------------------------------
//public Admin adminLogin(Admin admin) {
//	LOG.info("Service adminlogin");
//	if (adminRepository.findByAdminUsername(admin.getAdminUsername()) !=null
//			&& adminRepository.findByAdminPassword(admin.getAdminPassword()) != null)
//		return adminRepository.save(admin);
//	throw new AdminNotExistsException();
//}
//---------------------------------------------------------------------------------------------
//	public Admin adminLogin(Admin admin) {
//		LOG.info(" Service login");
//		tempUser = adminRepository.findByAdminUsername(admin.getAdminUsername());
//		if (tempUser.getAdminUsername().equalsIgnoreCase(admin.getAdminUsername())) {
//			isLoggedIn = true;
//			return tempUser;
//		}
//		throw new AdminNotExistsException();
//	}
//public Admin adminLogin(String adminUserName,String adminPassword) {
//LOG.info(" Service adminlogin");
//tempUser = adminRepository.findByAdminUsername(adminUserName.getAdminUsername());
//tempUser1 = adminRepository.findByAdminPassword(adminPassword.getAdminPassword());
//if (tempUser.getAdminUsername().equalsIgnoreCase(admin.getAdminUsername())) {
//	isLoggedIn = true;
//	return tempUser;
//} else if (tempUser1.getAdminPassword().equalsIgnoreCase(admin.getAdminPassword())) {
//	isLoggedIn = true;
//	return tempUser1;
//}
//throw new AdminNotExistsException();
//}

//public Admin adminLogin(Admin admin) {
//LOG.info("Service adminlogin");
//if (adminRepository.findByAdminUsername(admin.getAdminUsername()) !=null
//		&& adminRepository.findByAdminPassword(admin.getAdminPassword()) != null)
//	return adminRepository.save(admin);
//throw new AdminNotExistsException();
//}

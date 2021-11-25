package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	public abstract Admin findByAdminUsername(String adminUsername);

	public abstract Admin findByAdminPassword(String adminPassword);

//	public abstract Admin save(Admin adminUserName, Admin adminPassword);

}

package com.capgemini.service;

import com.capgemini.model.Admin;

public interface IAdminService {
        Admin adminRegister(Admin admin);
        Admin adminLogin(String adminUserName,String adminPassword);
}
